// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.twitter.heron.spi.common;

import java.util.Map;

public class PackingPlan {
  /**
   * Type definition of packing structure output.
   */
  public static class Resource {
    public Double cpu;
    public Long ram;
    public Long disk;

    public Resource(Double cpu, Long ram, Long disk) {
      this.cpu = cpu;
      this.ram = ram;
      this.disk = disk;
    }
  }

  public static class InstancePlan {
    public final String id;
    public final String componentName;
    public final Resource resource;

    public InstancePlan(String id, String componentName, Resource resource) {
      this.id = id;
      this.componentName = componentName;
      this.resource = resource;
    }
  }

  public static class ContainerPlan {
    public final String id;
    public final Map<String, InstancePlan> instances;
    public final Resource resource;

    public ContainerPlan(String id,
                         Map<String, InstancePlan> instances,
                         Resource resource) {
      this.id = id;
      this.instances = instances;
      this.resource = resource;
    }
  }

  public final String id;
  public final Map<String, ContainerPlan> containers;
  public final Resource resource;

  public PackingPlan(String id, Map<String, ContainerPlan> containers, Resource resource) {
    this.id = id;
    this.containers = containers;
    this.resource = resource;
  }
}