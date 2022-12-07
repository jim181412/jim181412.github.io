---
title: week 7 ADS
tags:
date: 15/11/2022
--- 

# MapReduce programming 

## Map function
it takes documents as input and emits key-value pairs 

```python
map(document_id,document_values):
    for w in documents_values:
        print((w,1))

```


## Reduce function
it takes a key and a list of value corresponding to the key as input;

```
reduce(word key2, list of count value2){
    sum = 0
    for each count in value2 do{
        sum = sum + count;
    }
    emit(key2,sum);
}
```



## Map reduce terminology
Some key concepts:
- job: 
  - the unit of work to be performed (can be several map and reduce tasks).
- split:
  - a part of the input.
- task
  - map or reduce functions created and run for each split / partition
- task trackers:
  - tracks the progress of each of the map or reduce tasks on a node.
  - keeps the job trakeer in formed of progress.
- job trackers:
  - coordinates the different tasks comprising a job

### From map side 
steps: 
1. The map tasks runs on split, generating key-value pairs
2. The output of map will be partitioned into groups, for sending to reduce tasks, typically by hashing.
3. The partitions will soretd by its key
4. The output will then be written to the local file system
5. the job traker is informaed by the task tracker when a task has completed.
### From reduce side
steps:
1. copy the map partitions
2. merge the partitions
3. run each tasks
4. store the output in distributed syste

```


```

### Pattern
A template for solving a common and general data manipulation problem in MapReduce.

summarization patterns
- aim: send less data from mappers to reducers, while still providing what the reducer needs. 
- an example of a numerical summarization would be compute a local sum of word counts in map. 
![picture](/learning/thrid_year_courses/advanced_distributed_system/images/picture1.png)
