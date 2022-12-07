---
title: week 2
tags: 
--- 

# Tokenisation
经典的tokenisation总共有四个步骤: 
- Initial segementation:
  -  去除空格和标点符号，括号，首尾的引号
- Handling abbreviations
  - 所有的标点符号（逗号，分号(semi-colon),引号，等等都是一个分别的符号
- Handling apostrophes(撇号)
  - 引号
  - 所有格符号
  - 附属词（enclitics）
- Handling hyphenation（连字符号）
  - 有很多不同的连字符号 比如说：
    - 在句尾的连字符
    - 真正的连字符： 词汇连字符 （比如说 meta-annalysis)
- 一些其他的表达 比如说邮件啊 链接啊 电话号码啊 日子和时间啊 度量符号啊 车牌号啊等等

## Case folding
- 我们应该把所有的符号都变成小写嘛？
- 如果我们这样做的话那我们得到了什么又失去了什么呢
- 很多正确的名词有普通的名词衍生而来 比如说 人的名字 Black 和 black 

# Language Model

## 什么是模型
- 模型是一个简化的抽象的对于一些东西的表达(representation)
  
## language model
- 最简单的模型: bag of words(BOW)
  - Reduce each document into a bag of words
  - questions related to bag of words representation：
    - Is the meaning lost without order?
    - What about negations? 
    - Are all words equally important?
    - Is the meanning list without context? Ambiguities?
    - Would it work for all languages? 
    - what about **important combination** of words? 

For bag of words representation: 
- Use all words ? Or we should skip some? 
  - 停用词需不需要移除呢
  - 最常见的词
- 我们需不需要给这些单词排序
  - Give some weight to more important ones
  - how do we decide on importance / relevance
  
### Zipf's Law
Frequncy of any word in a given collection is inversely
propotional to its rank in the frequency table.






### Searching for the term "bart the lover" in document '3.15.txt': 


**We found word 'bart' occurs in document '3.15.txt' at position:**  
[102, 181, 233, 483, 526, 682, 914, 963, 984, 1241]. 
Since it occurs firstly in the term 

**We found word 'the' occurs in document '3.15.txt' at position:**
[4, 23, 71, 96, 103, 106, 118, 122, 126, 131, 134, 142, 146, 154, 208, 227, 274, 281, 285, 293, 298, 316, 331, 340, 433, 452, 502, 505, 564, 588, 602, 625, 642, 658, 676, 714, 739, 746, 750, 752, 758, 761, 774, 789, 809, 817, 830, 835, 839, 846, 849, 881, 902, 908, 911, 937, 955, 958, 968, 979, 1000, 1003, 1006, 1029, 1038, 1045, 1055, 1070, 1091, 1095, 1136, 1155, 1158, 1166, 1174, 1177, 1188, 1197, 1200, 1224, 1235, 1273, 1286, 1293, 1306, 1314, 1350, 1358, 1371, 1382, 1392, 1396]. 

Since it occurs secondly in the document, we minus 1 for every element in position: then we have
[]
**We found word 'lover' occurs in document '3.15.txt' at position:**  
[104]




