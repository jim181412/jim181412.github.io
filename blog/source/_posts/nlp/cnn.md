---
title: Convolutional Neural NetWork
date: 2022/11/24
tags: Reinforcement Learning
category:  self-learning
---

## Overfitting
机器想把误差减少到最小， 当运用到实际数据时 不能成功的表达出了训练数据以外的其他数据

### 解决方法
1. 增加数据量
2. 用 regularization
   1. L1, L2 regularization
   2.   y = Wx
   3. L1: cost = $(Wx - real y)^2 + abs(W)$
   4. L2: cost = $(Wx = real y)^2 + (W)^2$

3. 在神经网络中， 运用dropout regularization
   1. 随机忽略一些elements 在神经网络中
   2. 让神经网络不过于依赖一些参数