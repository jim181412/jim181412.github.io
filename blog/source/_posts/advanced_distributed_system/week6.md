---
title: week 6 ADS
---



## Distributed Relational Data
Distributed data management
### distributed database
In a distributed database management system, data is stored in several databases, but can be queried from any places.
### parallel databases
In parallel database, data is stored and queried across several databases.

in parallel database, disks and memory are assigned to different processors. And each processor has its own private disk and memory and each processor is an independent entity. Share Nothing!

These processors communicate through interconnect.

Parallel databases can be used to speed up both online transaction processing (OLTP) and online analytical processing (OLAP) tasks.

### data integration
Data integration is a process of combining data from existing sources in a way that reduces heterogeneities.

data integration may leave the data where it is or copy the data from source.

Where the data is copied, ETL workflows are often used.(Extract, Transform, Load)



## Big data
4 V's of big data
- volumn: extreme scale
- variety: the data may be in different forms
- velcocity: the data may be changeing(arriving) quickly
- veracity(真实，准确): the data may be of variable quality                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 


### cloud service
Cloud services often belong to one of the following delivery models:
- infrastructure as a service (IAAS)
  - purchase **virtual machine**, storage
- platform as a service (PAAS)
  - purchase of **software** used to build applications.
- Softwar-as-a-service (SAAS)
  - purchase of a end-user **application**
- database-as-a-service(BDAAS)
  - provide cloud hosting of database systems.

#### Database As A Service
- DBaaS supports the full range of database platforms:
  - established relational vendors: migrating customers from on-premise to clouds.
  - NoSQL vendors: for web-scale simple-request applications that require elasticity.
  - Cloud data warehouses, such as Snowflake.
- DBaas is also associated with a variety of tooling, such as:
  - Matillion for ETL in cloud.
  - Dabase miragation tools, on-premise(本地) to cloud   


### Distributed data challenge
issues for the development if data-intensive applicaitions:
- **Reliability**: the ability to continue working correctly evetn when things go wrong.
- **Scalability**: the ability to cope with increased load(e.g., in terms of )
- **matainance**: make it easy for operations teams and accommodating evolvability.
  

## Partition
In data intensive applications, parallel processing involves distributing the data accross the available nodes.
The distribution of the data is referred to as partitioning or sharding.

### partition:
Techinically, partitioning involves deciding how to assign data from a source onto distributed nodes.
- data can be partitioned in different ways: 
    - **round robin and random**: data is assigned as it is inserted accross different node.
      - pros:
        - uniform initial distribution 
        - easy to rebalance on update(update)
      - cons: 
        - quering involves accessing all nodes.
    - **partition related to the key**:
      -  pros: 
         -  focused range queries on key
         -  focused direct access on key
      -  cons: 
         - uniform distribution not intrinsic
         - risk of hot spots for popular keys
         - rebalancing can be expensive
         - only helps for key-based requests
    - **partition by hash on the key**:
      -  pros: 
         -  uniform distribution with certain keys
         -  focused direction access on key
      - cons: 
        - rebalance can be expensive 
        - only helps for requests that have the key
        - risk of hot spots for pupular keys
        - no support for range queries
  
- Paritioning by key means choosing suitable key.
  what features are desirable in a key, given examples? 
  ![picture 1](/learning/thrid_year_courses/advanced_distributed_system/images/%E6%88%AA%E5%B1%8F2022-11-16%2017.05.23.png)

|Desirable|Examples|
|-|-|
|Used for direct access requests|Name,Town|
|diverse values|Id,name,Town,Size|
|not subject to skew|Id, Name, Town, Size|
|can be used for range access requests|Size|



### skew and hot spots
Skew is when the partitioning is uneven.
- For example, a partition on the first letter of country in the university table.
  
A hot spot arises when the load is unevenly balances.
- For example, many more people may look up some universities than others.

### Repatitioning
If we assume a uniform distribution, and a mod-based partition, the fraction of the data that needs to be repartitioned can be estimated as:
  - To-Redistribute = $1 - \frac{1}{final-nodes}$
  - the number of tuples moved is: $( 1 - \frac{1}{final-nodes}) * (number-of-data)$

What fraction of the data needs to relocate if there are $x$ nodes and many partitions, and we want to add a further node while continuing to spread the data uniformly?
  - Fraction moved = $\frac{1}{x+1}$
 
## Second indexes
Definition: A secondary index is an idnex on an attribute that has not been used for partitioning. 

### store of secondary indexing
where the secondary index is stored.
- one option is that the secondary index is stored on the same node as the data it is indexing. In this case, there are many local indexes.
  - For example:![picture2](/learning/thrid_year_courses/advanced_distributed_system/images/%E6%88%AA%E5%B1%8F2022-11-16%2017.57.25.png)
  - pros and cons:
    - pros: updating a document will lead to the change of local index(so no distributed transaction)
    - cons: A lookup needs to go to every partition, leading to many index lookups.

- second option is that the secondary undex is stored parititioned by term: a single distributed index.
  - For example:![picture2](/learning/thrid_year_courses/advanced_distributed_system/images/%E6%88%AA%E5%B1%8F2022-11-16%2017.57.39.png)
    - pros: index lookups no longer need to go to all nodes(note some index lookups will have no hits)
    - cons: updates to a document on a node now also lead to index updates(and thus potentially to distributed transactions)

###
