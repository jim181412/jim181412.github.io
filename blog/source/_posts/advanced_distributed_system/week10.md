---
title: week 10 ads
tags: ADS
categories: ADS
date: 2022/12/06
---



## framework supports stream processing
data flow graphs may distribute data to different computational nodes.
1. Apache Storm 
2. Apache Flink
3. Apache Spark

### throughput and latency
latency:

throughut:
## Operating on Streams
- A stream is a sequence of data items that become available over time.
- Streams are typically processed using data flow graphs, in which the nodes consume and produce streams.
- As we cannot wait for a stream to end before doing any processing , data must be processed incrementally.


Window Features:
- the length of window
- whether or not windows overlap
- when a window is processed

windows:
- event-based.(length is number of events)
- time-based tumbling window.(the length is a time interval)
- slide window, length and slide are number of events.
- session window(group of events occur within a gap of each other)

when to use this window?
1. Analysis of trending tweets
2. Analysis of journeys of drivers
3. Analysis of product sales by time of days.


Event and processing time
- Event time: when something actually happens
- Processing time: the time of the clock that in the machine when the operation is taking place.

pros and cons of event and processing time
- event time:  
  - pros: low latency, no need to wait for event to arrive
  - cons: Nondeterminstic(arrivial rates determine results)
- processing time:
  - pros: deterministic(use application semantics for time)
  - cons: high latency(may need to wait until all relevant events have arrived)



## Delays and Failures
Delays are not failures, but failures will lead to delays.  

Watermarks: for event-based operations, how long it should wait before processing a result. 


