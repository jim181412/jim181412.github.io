---
title: week 9 Advanced Distributed System
tags: ADS
categories: ADS
date: 2022/11/29
--- 

## NoSQL databases
6 abilities to dinstinguish NoSQL databases.
- To horizontally scale the throughout of simple-operation workloads to several servers.
- To replicate and distribute(through partitioning) the data over servers.
- To expose a simple call-level interface or protocol
- To offer less restrict transactional guarantees.
- To use distributed indexes efficiently for replication-rich, elastic
provision of data storage.
- To cope with variations in the structure of objects stored.

### Types of NoSQL database.
1. key-value
2. document
3. 













## Replication
1. Benifits and cost:
   1. benifits:
      1. keep the data close to user
      2. allow the system to keep working if some of the nodes failed(avaibility)
      3. increase the number of machine available to support read queue
   2. cost:
      1. extra storage for replicas
      2. extra costs for update
      3. mechanisms required to maintain consistancy.

### update model
- leader and followers.
  - failure and possible solutions
    - the leader fails : promote a follower to be a leader.
    - the follower fails: redirect requests, apply the replication log when the follower comes back.
    - the leader and follower are not consistency for a time: impose strict transactions or live with short term inconsistency.

#### synchronic and asynchronic replication
- in synchronous, the leader returns success if all followers are updated
- in asynchronous, the leader returns success before knowing if all followers have been updated.
- in semi-synchronous, the leader returns success if one of the followers is updated.
  
pros and cons of synchronous and asynchronous replication
Synchronous replication
- pros: replications are sure to be consistent with the leader
- cons: blocks if any follower is down
Asynchronous replication
- pros:  No delay waiting for writes to be propagated .
- cons: There are temporary inconsistencies between leader and followers. Writes that have not been replicated are lost if the leader fails(loss of durability)
Semi-synchronous replication
- pros: writes are not lost due to a single node failure.
- cons: blocks if the nominated follower is down, or need more complicated protocol to handle nominated follower failure. 
### coping with failure
the replication must:
- amenable to (configuration / software version / scale) changed over time
- robust to failure.

Question:
if a follower crashes temporarily, what steps can it take to recover when it starts up again?
1. identify when it last processed a replication log from the leader.
2. request the replication log from that time from the leader.
3. apply the replication log.

Then it can proceed as normal, responding to user queries and obtaining changes from the leader.
The long-term loss of a follower may lead to a new follower being added to replace its place. 

Leader failed
1. determine the leader has failed
2. pick a new leader (failover)
3. inform the clients and other followers about the new leader. 
   

### Replication Logs 
Three types:
1. statement-based
2. write-ahead log based
3. logical log based

   
