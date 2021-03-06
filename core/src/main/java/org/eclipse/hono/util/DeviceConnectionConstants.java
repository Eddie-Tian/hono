/*******************************************************************************
 * Copyright (c) 2019, 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.hono.util;

/**
 * Constants &amp; utility methods used throughout the Device Connection API.
 */

public final class DeviceConnectionConstants extends RequestResponseApiConstants {

    /**
     * The default name of the (remote) cache in the data grid that is use for
     * storing device connection information.
     */
    public static final String DEFAULT_CACHE_NAME = "device-connection";

    /**
     * The name of the field that contains the identifier of a gateway.
     */
    public static final String FIELD_GATEWAY_ID = "gateway-id";

    /**
     * The name of the optional field in the result of the <em>get last known gateway for device</em> operation
     * that contains the date when the last known gateway id was last updated.
     */
    public static final String FIELD_LAST_UPDATED = "last-updated";

    /**
     * The name of the field that contains the list of objects with protocol adapter instance id and device id.
     */
    public static final String FIELD_ADAPTER_INSTANCES = "adapter-instances";

    /**
     * The name of the field that contains the identifier of the protocol adapter instance.
     */
    public static final String FIELD_ADAPTER_INSTANCE_ID = "adapter-instance-id";

    /**
     * The name of the field that contains the array of gateway ids.
     */
    public static final String FIELD_GATEWAY_IDS = "gateway-ids";

    /**
     * The name of the Device Connection API endpoint.
     */
    public static final String DEVICE_CONNECTION_ENDPOINT = "device_con";

    /**
     * The vert.x event bus address to which inbound device state messages are published.
     */
    public static final String EVENT_BUS_ADDRESS_DEVICE_CONNECTION_IN = "devcon.in";

    /**
     * Request actions that belong to the Device Connection API.
     */
    public enum DeviceConnectionAction {
        /**
         * The <em>get last known gateway for device</em> operation.
         */
        GET_LAST_GATEWAY("get-last-gw"),
        /**
         * The <em>set last known gateway for device</em> operation.
         */
        SET_LAST_GATEWAY("set-last-gw"),
        /**
         * The <em>get command handling protocol adapter instances</em> operation.
         */
        GET_CMD_HANDLING_ADAPTER_INSTANCES("get-cmd-handling-adapter-instances"),
        /**
         * The <em>set command handling protocol adapter instance</em> operation.
         */
        SET_CMD_HANDLING_ADAPTER_INSTANCE("set-cmd-handling-adapter-instance"),
        /**
         * The <em>remove command handling protocol adapter instance</em> operation.
         */
        REMOVE_CMD_HANDLING_ADAPTER_INSTANCE("remove-cmd-handling-adapter-instance"),
        /**
         * The <em>unknown</em> operation.
         */
        UNKNOWN("unknown");

        private final String subject;

        DeviceConnectionAction(final String subject) {
            this.subject = subject;
        }

        /**
         * Gets the AMQP message subject corresponding to this action.
         *
         * @return The subject.
         */
        public String getSubject() {
            return subject;
        }

        /**
         * Construct a DeviceConnectionAction from a subject.
         *
         * @param subject The subject from which the DeviceConnectionAction needs to be constructed.
         * @return The DeviceConnectionAction as enum
         */
        public static DeviceConnectionAction from(final String subject) {
            if (subject != null) {
                for (DeviceConnectionAction action : values()) {
                    if (subject.equals(action.getSubject())) {
                        return action;
                    }
                }
            }
            return UNKNOWN;
        }

        /**
         * Helper method to check if a subject is a valid Device Connection API action.
         *
         * @param subject The subject to validate.
         * @return boolean {@link Boolean#TRUE} if the subject denotes a valid action, {@link Boolean#FALSE} otherwise.
         */
        public static boolean isValid(final String subject) {
            return DeviceConnectionAction.from(subject) != DeviceConnectionAction.UNKNOWN;
        }
    }

    private DeviceConnectionConstants() {
        // prevent instantiation
    }
}
