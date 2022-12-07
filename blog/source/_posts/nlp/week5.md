---
title: week 5 nlp
tags:
---


# Week 5

## word sense definition
Word sense disambiguation (WSD) is selecting which sense of a word is used in a given piece of text
(e.g., a sentence) from a set of multiple known
possibilities (sense candidates).


## 2 typical types of wsd approaches
- knowledge-based approaches
    - use external knowledge, dictionaries and thesaurus
- Supervised machine learning approaches
  - use labelled training examples

## Lesk algorithm
- Core idea: To examine the definition overlap in all possible sense combinations among all words in the given text
- implementation： 
  - Retrieve from the dictionary all sense definitions of the words in the given piece of text
  - Calculate the definition overlaps for all possible sense combinations
  - choose the senses that offers the highest overlap

## Faster Solution
- Simplified Lesk examines overlap between sense denitions of a word and its current context.
  - Retrieve from the dictionary all sense definitions of the word to be disambiguated.
  - Calculate the overlap between each sense definiton and the current context.
  - Choose the sense that leads to the highest overlap.

## Comparision of two algorithms (Lesk and Simlified)
- Given a sentence containing $N$ words, each word has $m_i$ available senses,
- the time needs for checking overlapping words: 
  - lesk algorithm: $m_1 * m_2 * m_3 * ... * m_N$
  - simplified algorithm: $m_1 + m_2 + m_3 + ... + m_N$


## WSD by classificaton

### supervised learning
- goal: predict the output for giving input pattern
- training examples: a set of examples data patterns are provided, and we know the output of each example
  - These training examples guides the computer to build a predictive mapping between an input data pattern and desired output
- Annotated training corpus: a collection of training examples
  
### From WSD to classification

classification: Assign an input data pattern to one of a pre-defined set of classes(categorical output)

- Convert WSD to classification:
  - An input data pattern: a word in a text
  - Pre-defined set of classes: dictionary senses
  - Training corpus: a collection of words tagged in context with their sense.

- One option is to train one classifier to identify the sense for one word. N words in the dictionary requires to build N classifiers.
  


Joint probability: $P(X,Y) = P(X) * P(Y)$  probability of two simultaneous events. 

Conditional probability: $P(A|B)$ probability of event A given the occurrence of event B

The joint probability can be calculated by conditional probability:  
$P(A,B) = P(A|B) * P(B)$


### examples
![nlp_1](/images/figures_1.png) 
compare the possibility of:   



$P((line,guitar,jazz,jazz), bass1)$ and $P((line,guitar,jazz,jazz),bass2)$

$$
\begin{aligned}
P((line,guitar,jazz,jazz),bass1) 
&= P((line,guitar,jazz,jazz)|bass1) * P(bass1) \\
&= P(line|bass1) * P(guitar|bass1) * P(jazz|bass1) * P(jazz|bass1) * P(bass1)
\end{aligned}
$$

$$
\begin{aligned}
P((line,guitar,jazz,jazz),bass2) 
&= P((line,guitar,jazz,jazz)|bass2) * P(bass2) \\
&= P(line|bass2) * P(guitar|bass2) * P(jazz|bass2) * P(jazz|bass2) * P(bass2)
\end{aligned}
$$

According to the euqation:  
$$
\begin{aligned}
&P(word|class) = \frac{ number\_of\_occurrence\_of\_word\_in\_class + 1 }{number\_of\_words\_given\_class + V} \\
&P(class) = \frac{\text{Sample number in the class}}{\text{Total Sample Number}}
\end{aligned}
$$

Therefore we have:
$$
\begin{aligned}
&P(bass1) = \frac{3}{4} \text{ and } P(bass2 ) = \frac{1}{4} \\
&P(line|bass) = \frac{1 + 1}{8 + 6} = \frac{1}{7}
\end{aligned}
$$




## Bootstrapping techniques
However, what should we do if we dont have enough training examples?

- create some new training examples by applying rules to generalise the small set of given training samples. (Semi-supervised learning)
  - "One sense per collocation(搭配) " rule: a word reoccurring in collocation with the same word will 
   almost surely have the same meaning.
  - "One sense per discourse": The sense of a word is highly consistence within a document, especially topic-specific words


### From WSD to sequence labeling
- Sequence labeling is the task of assigning a sequence of labels to a sequence of observations
- A machine learning model can be built to map an input sequence(no label) to an outout sequence(has labels).
  - $[y_1,y_2,...,y_n] = f(x_1,x_2,...,x_n)$
- A WSD task can be naturally converted to a sequence labeling task: 

![figure2](/images/figures_2.png)


### WSD evaluation and baselines
- Check sense accuracy (intrinstic evaluation)
  - % percent of words tagged indentically with the human-manual sense tags.
  - Usually evaluate using held-out data from same labeled corpus.
- Task-based evaluation (extrinsic evaluation).
  -  embed WSD in a NLP task and see if you can do the task better.
- **Baselines** for comparision: 
  - Assign the most frequent sense
  - Compare with simplified lesk, (47% on senseval-2 data), if your implement results in a result lower than 47%, Then its a bad implementation.
- Human agreements on all-words corpora with WordNet style senses are around 75% - 80%.

### Approaches
- knowledged based
  - lesk
  - simplified lesk
  - corpus lesk
- supervised machine learning
  -  feature extraction
  -  naive bayes 
- hybrid machine learning (advanced machine learning method)
  - sequence labeling 
  - semi-supervised learning(bootstraping)


# week 5 homework
![question 1](/images/截屏2022-11-09%2020.51.28.png)

Answer: 
We calculate the overlaps of all combinations of senses of words in the phrase,

hard#1drink#1 overlap: 2 (alcolholic and liquor)
hard#1drink#2 overlap: 0 
hard#2drink#1 overlap: 0
hard#2drink#2 overlap: 0
hard#3drink#1 overlap: 0
hard#3drink#2 overlap: 0

Therefore, we pick the senses combianations with highest number of overlaps, which is hard sense1 and drink sense 1.

![question 2](/images/截屏2022-11-09%2021.07.46.png)

Answer:
a) because the sentence is so long, if we need to calculate for all combinations of senses of words in the given sentence. 
Then we have to check $m_1 * m_2 * ... * m_n$ (n is number of words in the sentence) combinations. It is time-consuming and impractical.

b) We first get all senses of word 'hard ' from the dictionary, and then calculate the overlaps between each sense and context. Finally, we pick the sense with highest number of overlaps 

![question 3](/images/截屏2022-11-09%2021.32.25.png)

Answer: 

```python
import nltk
from nltk.wsd import lesk
from nltk.tokenize import word_tokenize
from nltk.corpus import wordnet as wn
sentence = "Although X-ray is heavily researched in Japan, it is very difficult to use to draw lines on a chip because the X-ray particles are hard to control"
sentence = word_tokenize(sentence)
print(lesk(sentence,'hard'))

for ss in wn.synsets('hard'):
    print(ss, ss.definition())
```


![question 4](/images/截屏2022-11-09%2021.32.57.png)

Answer: 
question1: 
$$
\begin{aligned}
P((liquor, lawyer, work), hard1) 
&= P((liquor, lawyer, work)| hard1) * P(hard1) \\
&= P(liquor|hard1) * P(lawyer|hard1) * P(work|hard1) * P(hard1) \\
&= \frac{4+1}{9+8} * \frac{1}{9+8} * \frac{1+1}{9+8} * \frac{1}{2} \\
&= 5/17 * 1/17 * 2/17 * 1/2 
&= 0.001
\end{aligned}
$$

$$
\begin{aligned}
P((liquor, lawyer, work), hard2) 
&= P((liquor, lawyer, work)| hard2) * P(hard2) \\
&= P(liquor|hard2) * P(lawyer|hard2) * P(work|hard2) * P(hard2) \\
&= \frac{1}{10+8} * \frac{1+1}{10+8} * \frac{2+1}{10+8} * \frac{1}{2} \\
&= 1/18 * 2/18 * 3/18 * 1/2 
&= 0.0005
\end{aligned}
$$

Therefore, using sense1 for hard in query {liquor,laywer,work}

question2:
$$
\begin{aligned}
P((task,work,duty,work),hard1)
&= P(task|hard1) * P(work|hard1) * P(duty|hard1) * P(work|hard1) * P(hard1) \\
&= \frac{1}{17} * \frac{2}{17} * \frac{1}{17} * \frac{2}{17} * \frac{1}{2} \\
&= 2.39e-5
\end{aligned}
$$
$$
\begin{aligned}
P((task,work,duty,work),hard2)
&= P(task|hard2) * P(work|hard2) * P(duty|hard2) * P(work|hard2) * P(hard2) \\
&= \frac{2}{18} * \frac{3}{18} * \frac{2}{18} * \frac{3}{18} * \frac{1}{2} \\
&= 1.71e-4
\end{aligned}
$$
Therefore, sense2 for hard in query {task,work,duty,work}.





