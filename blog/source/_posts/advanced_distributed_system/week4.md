---
titile: week4
tags: 
---

# week4 Resource management in Distributed System

## Resoucres in distibuted System

1. HardWare. E.g.: - CPU, network links, storage
2. Software: web services
3. datasets

Applications需要不同的分享这些资源
Distributed System需要优化这些资源的使用根据这些资源的可用性  

## Grid Computing
### Definition
Resource sharing and coordinated problem solving in a dynamic virtual organizations



## Cloud Computing
- largely evolved from grid
- The idea:
  - On-demand resource provisioning.Users of the cloud are consumers who dont have to own the resources they use;
  - These resources are provided by others(provider) as a service
- Relies on virtualisation of resources that create virtual machine as opposed to physical machine
- Elasticity: resources can be added on demand:
  - horiziontal elasticity: add or remove new resouces instance
  - increase or decrease resouces attributes

  ### Cloud Computing Service model
  -  software as a service
  -  infrastructure as a service
  -  platform as a service 

### Two distinct Role
- The cloud provider(owner of the resources)
  - Objective: 
    - maximise the income
    - minimise costs
  - Needs to allocate Virtual Machines to Physical Machine
- The cloud Consumers(client)
  - Objective:
    - Obtain resources as cheap as possible
    - decide how much recourses they need

### VM allocation
From cloud provider:
- many VMs need to share PMs, what is the best way to allocate VMs to PMs to meet various objectives:
  - Service Layer Agreement with the usrs
  - Maximise resource utilization
  - Minimise ennegy costs

###