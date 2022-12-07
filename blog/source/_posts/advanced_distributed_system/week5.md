---
title: week 5 Distributed System
tag: 
date: 18/10/2022
--- 

# Week 5 Distributed System

## Edge computing
- Definition:
  -  placing worlloads as close to the edge
  -  edge: where the data's being to create and where actions are being taken


## Heterogeneous Earliest Finish Time (HEFT)
- Produce a schedule for execution of DAG on a given number of resources aimming to minimise the total completion time while metting the task dependencies
- **Key Idea** : give priority to the critical path
- The algorithm works in two phases:
  - give a priority to each task; create a priority list
  - following the priority list, assign a task to the resource resulting in the earliest finish time for the task
- This is s heuristic, it tries to find local optimal but it might not be global optimal

## From Cloud to Fog / Edge computing 
- Cloud Computing Data Centres are a centrally operating infraustructure(基础设施) to handle data
- data is often produced from devices that are connected to the Internet.我们需要把所有的数据都送往云端服务器吗
  - edge computing:  尝试处理一些东西在边缘，离数据的来源很近的地方，目的是为了减少送往云端数据的数量
  - Fog Computing: 在中心云端服务器和边缘加一些额外的层
  - 围绕处理数据的问题有很多权衡

## 如何使用资源 
- 在任务图中，在资源，运行完毕所需时间和资源利用率中是有所权衡的
  - 额外的资源应该会提升运行完毕所需时间但是会降低资源的利用率
  - 在普遍的情况下，我们应该找到最大程度的平行（最大数量的独立的任务），我们应该使用小于等于这个最大数量独立任务的资源 
- 三个方面代表最优调度问题
  - $\alpha$ 机器的环境
  - $\beta$ 工作的特性和限制
  - $\gamma$ 目标方程
- 描述一些现实世界的问题用这三个方面：
  - 排班是一个常见的调度问题：
    - 在安排给学生上课的问题中，这里有很多个教室有着固定的容量(资源： 机器的环境)
    - 然后有很多学生需要上课（工作的特性和环境）， 然后这里会有很多优化目标方程去减少总共教室的使
  - 另外的一个例子就是制造业的东西：
    - 比如说一个汽车制造商有n个制造汽车的车间（resources）， 他们需要制造不同的零件（jobs）
    - 需要做的就是汽车制造商要减少总共制造的花销和优化制造的数量（目标方程）
  - 
 
 - 
