/**
 * Copyright 2016 Smoke Turner, LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.dropwizard.consul.jersey;

import java.util.Objects;
import javax.annotation.Nonnull;
import org.glassfish.hk2.api.Factory;
import com.orbitz.consul.Consul;

public class ConsulFactory implements Factory<Consul> {

    private final Consul consul;

    /**
     * Constructor
     *
     * @param consul
     *            Consul client
     */
    public ConsulFactory(@Nonnull final Consul consul) {
        this.consul = Objects.requireNonNull(consul);
    }

    @Override
    public Consul provide() {
        return consul;
    }

    @Override
    public void dispose(Consul instance) {
        // nothing to dispose
    }
}