/*
 * Copyright © 2018 Smoke Turner, LLC (contact@smoketurner.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.smoketurner.dropwizard.consul.health;

import com.codahale.metrics.health.HealthCheck;
import com.orbitz.consul.Consul;
import com.orbitz.consul.ConsulException;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsulHealthCheck extends HealthCheck {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsulHealthCheck.class);
  private final Consul consul;

  /**
   * Constructor
   *
   * @param consul Consul client
   */
  public ConsulHealthCheck(final Consul consul) {
    this.consul = Objects.requireNonNull(consul);
  }

  @Override
  protected Result check() throws Exception {
    try {
      consul.agentClient().ping();
      return Result.healthy();
    } catch (ConsulException e) {
      LOGGER.warn("Unable to ping consul", e);
    }
    return Result.unhealthy("Could not ping consul");
  }
}
