---
title: week 9 NLP
tags: NLP
categories: NLP
date: 2022/11/28
mathjax: true
--- 


# Neural Language Model
- predict the $(k+1)th$  word given the first k words using a feedforward network archietcture.
  - input, $x_1 = e_1 F$  $\quad e_1$ is one hot vector explanation of a word, and $F$ is a word embedding matrix
  - then we have the input(concatenated vector). $\newline$ $\quad x = [x_1,x_2,x_3,...]$
- RNN 
- RNN-based Tagging Model
- RNN-based Seq2Seq Model

## Advanced Deep Learning Model 
- Bi-direction RNN
  - Concatenate hidden representations computed by two RNNs using the oringinal and reversed sequences as the input, repectively
  - Benifits: Take care of both left and right context, as the representation vector of a state is affected by its left and right states.
- Multi-Layer RNN 
  - become deep by stacking multiple layers of RNN
  - Benifits: Compute more complex representation vectors and improve model performance.
  - High-performing RNNs are often multi-layer. e.g, 2-4 layers. But this is not as deep as CNNs and other feedforward nerual network.
  - For each state in multi-layer RNN, the output of the hidden layer $i$ in used as the input of the hidden layer $i+1$