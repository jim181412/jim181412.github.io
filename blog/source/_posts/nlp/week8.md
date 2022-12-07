---
title: week 8 Deep Learning
tags : NLP
category: NLP
--- 

## Deep Learning
deep Learning emphasis on networks with higher number of layers.

###  use of nn
- predict probability
- sequence representation and classification
- sequence labelling 
  -  it can be used to learn a representation vector for each sequence state, and use it to predict label for each state
  -  example: POS tagging
- sequence to sequence labelling 
  - encode information in a input sequence and decode it to generate an output sequence.
  - example: 
    - machine translation(机器翻译) ,
    - speech recognition(input a sequence of speech feature vector and output is a sequence of words)
    - Question answering. input context and question, output answer.

### review 
<!-- - activation function, ![]() -->

- Multilayer Perceptron
  - MLP, also called feedforward artificial neural network, consists of 3 layers of node, input, hidden and output layers.
  - In a fully connected neural network, each neuron is connected to all the neurons in the previous layer through non-zero weight.
- CNNs are good at capturing data patterns existing in a 3-D data cube or a 2-D data matrix, widely used for processing images, videos, text and signals.
- Recurrent Neural Network. RNN
- Prediction layer:
  -  most NlP tasks can be decomposed into a series of classfication tasks.
  -  The hidden representation vectors returned by neural networks are used as the input of a logistic regression model(a classifier). This is referred as the prediction layer.
  -  Training neural network weights aims at minimising a classification error loss calculayed using your training data.
  -  Cross entropy loss is a common option.
  
### Some explaination of RNN
- input
  - A raw representation of a word sequence is a sequence of one-hot vectors
  - 