+++
title = "Multi-Tenancy"
weight = 185
+++

Hono is designed to structure the set of all internally managed data and data streams into strictly isolated subsets. 
This includes the registration data and credentials of devices, internal users that are used for authentication, 
and the *Business Applications* that are part of such subsets as well.

This way of *strict* isolation is generally known as multi-tenancy, where a **tenant** is the term for such a subset.
Such an isolation is essential for enabling a scalable distributed architecture to handle independent subsets as if each subset had its
own installation (which would be much harder to maintain and would not benefit from runtime cost sharing).

Hono's multi-tenancy concept is based on handling tenants as own *entities*. All functionality of Hono is 
provided in the context of a previously created tenant - except the creation of a tenant itself. 

In the following the different aspects of multi-tenancy in Hono are addressed and a full overview of the concept is given.

## The Tenant API

By means of the [Tenant API]({{< relref "/api/tenant" >}}) Hono handles tenants as own *entities*.
The API defines how to *retrieve* the details of a specific tenant. This offers the possibility to handle arbitrary
properties on the level of a tenant (see e.g. [Protocol adapter configuration]({{< relref "#protocol-adapter-configuration" >}})).
For convenience, there are CRUD operations for the handling of tenants, which can be found in the 
[Device Registry]({{< relref "device-registry.md#managing-tenants" >}}).

## Protocol Adapters respect the Tenant API

When a device connects to one of Hono's protocol adapters, the adapter determines the tenant this device belongs to.
How this is done is described in the User Guide.
After the tenant is determined, the adapter retrieves the details of the determined tenant by means of the Tenant API.
Only if the tenant exists and is enabled the adapter further processes the data of the device that is connecting. Otherwise
the connection will be closed.

## Protocol Adapter Configuration

Protocol adapters retrieve parts of their configuration on a tenant level by using the details of the determined tenant.
This includes e.g. if a specific protocol adapter is enabled at all for this tenant, allowing to define tenants with 
only a subset of Hono's functionality. This feature is foreseen to be especially important for production setups.

*Example*: a tenant that

- can use the MQTT protocol adapter
- but is not allowed to use the HTTP protocol adapter


Please refer to the [Tenant API]({{< relref "/api/tenant" >}}) to find out which protocol adapter properties 
can be configured at the tenant level.

## AMQP 1.0 Endpoints

The AMQP 1.0 endpoints for all APIs of Hono are scoped to a tenant, by using the scheme `<api-name>/TENANT/...`.

*Examples*:

- `telemetry/TENANT`
- `registration/TENANT`

etc.

This separates the AMQP endpoints from each other on a tenant level.

The only exception to this is the [Tenant API]({{< relref "/api/tenant" >}}), which does not follow this scheme since it
is addressing the tenants themselves.   

## Devices and Tenants

A physical device will usually be represented in Hono as an entity in the device registry, having a unique identity 
and belonging to exactly one tenant. All data sent from a device, as well as from the application to the device, 
is therefore treated as belonging to the corresponding tenant.

The following diagram shows the relation between tenants, devices and their credentials:

{{< figure src="../Tenants_Devices_Credentials.png" title="Tenants, Devices and Credentials">}}


## Tenant based Flow Control

An important detail in Hono's architecture is that data sent downstream is transported via the tenant
scoped AMQP 1.0 links from the protocol adapters to the AMQP 1.0 network.
Each tenant has its own pair of AMQP 1.0 links and is treated 
independently from other tenants regarding the back pressure mechanism that AMQP 1.0 offers.
This enables a *Business application* to limit the rate at which it consumes AMQP 1.0 messages per tenant.

For the other direction, when commands are sent from the application to the device, the rate is also limited per tenant.
 
## Authorization at Tenant Level

Hono's components authenticate each other by means of the [Authentication API]({{< ref "/api/authentication" >}}).
The returned token for a successful authentication contains authorization information that is addressing the AMQP 1.0
endpoints. Since the endpoints (as outlined above) are scoped to a tenant, this enables to configure tenants that are
authorized to only a subset of Hono's full functionality.

*Example*: a tenant (defined by means of authorization configuration) that 

- is allowed to send telemetry data downstream
- but is not allowed to send event data

This is done by not including the event endpoint in the authorization token for these tenants.

## Business Applications and Tenants

The northbound *Business applications* are always connecting to the AMQP 1.0 endpoints of Hono.
By means of the authentication and authorization setup and the fact that the endpoints are scoped to a tenant, the 
*Business application* is only acting in the context of one tenant.


## Separation of Tenants

Tenants are separated from each other in all of Hono's components. 
Here is a summary of how this is implemented:

- the registration of devices are strictly scoped to a tenant
- the credentials of devices are strictly scoped to a tenant
- protocol adapters can be enabled/disabled for a tenant 
- the downstream data flow is isolated for every tenant
- the upstream data flow ([Command &amp; Control]({{< ref "/concepts/command-and-control" >}})) is isolated for every tenant
- *Business applications* need to authenticate to the AMQP 1.0 network and are by that mechanism scoped to their tenant
 
## Hints for Production

To be flexible for the different needs of production setups, Hono tries to make as few assumptions about the combination
of the different APIs as possible.
This means e.g. that the Device Registry does not enforce referential integrity of the APIs:

- devices can be created for a tenant that is not existing (yet)
- credentials can be created for a tenant and/or a device that is not existing (yet)
- tenants can be deleted and leave their scoped devices and credentials still in the configuration (which may not be usable
  anymore, since the tenant is missing)

These are points that production setups may want to implement differently.
