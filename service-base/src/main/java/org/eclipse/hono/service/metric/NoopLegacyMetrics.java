/*******************************************************************************
 * Copyright (c) 2019 Contributors to the Eclipse Foundation
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

package org.eclipse.hono.service.metric;

/**
 * A no-op legacy metrics implementation.
 */
public class NoopLegacyMetrics implements LegacyMetrics {

    /**
     * Creates a new instance.
     */
    protected NoopLegacyMetrics() {
    }

    @Override
    public void incrementUndeliverableMessages(final MetricsTags.EndpointType type, final String tenantId) {
    }

    @Override
    public void incrementProcessedMessages(final MetricsTags.EndpointType type, final String tenantId) {
    }

    @Override
    public void incrementNoCommandReceivedAndTTDExpired(final String tenantId) {
    }

    @Override
    public void incrementCommandResponseDeliveredToApplication(final String tenantId) {
    }

    @Override
    public void incrementCommandDeliveredToDevice(final String tenantId) {
    }
}