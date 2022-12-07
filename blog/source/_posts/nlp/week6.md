---
titles: week6 nlp
tags:
---

# Week 6 NLP

## Semantic Processing
- it is important for the computer to understand what words mean in a given context. This is known as the semantic processing step in nlp.
## Distributional Hypothesis
- perhaps we can infer the meaning of a word just by looking at the context it occurs in? 
- perhaps words appearing similar contexts share similar meanning?
## Distributional semantics
- It assumes contextual information alone constitutes a viable representation of linguistic items, in contrast to formal linguistics and the formal theory of grammar.
## Distributional Semantic Model
- Basic idea: 
  -  Generate a **high-demensional feature vector** to characterise a linguistic item.
  -  Subsequently, the semantic similarity between the linguistic items can be quantified in terms of **vector similarity**
- The linguistic items include, for example, words(or word sense), phrases, text pieces(windows of words), sentences, documents, etc.
## Semantic Space
- The computed high-dimensional space is called **semantic space**, which also has other names such as embedding space, latent representation space, etc.
  - A distance function between two vectors can be used to measure how dissimilar their corresponding linguistic items are. (Euclidean distance)
  - A similarity function between two vectors can be used to measure how similar their corresponding linguistic items are. (Cos similarity)
## Vector Space Model (VSM)
- it is count based. 
- it is an algebraic model for representing a **piece of text object**(document) as a vector of index terms.
- in the document vector, each feature value represented the count of an index term appearing in a relevant document.
- By collecting many document vectors and storing them as matrix rows(or columns), we then have the document-term matrix.
  

## VSM for word similarity
- construct word vectors by vector space model.
- use consine (inner product) similarity to compute the similarity between the word vectors.
- Two typical approaches for getting word vectors.
  - based on documents
  - based on local context.

### Document based word similarity
- word vector by documents:
  - build doucment-term matrix
  - calculate similarity between words using the word vectors(row vectors in this case)

### Context-based word similarity
- word vector by local context:
  -  build your term-context matrix(term is the index term and context is a vocabulary list(dictionary))
  -  calculate the similarity between words using word vectors.

- How to choose the context
  - Many options: 
    -  The whole document that contains the target word.
    -  all words in a wide window of the target word.
    -  content words in a wide window of the target word.
    -  content words in a narrow er window of the target word.
    -  content words in a narrower window of the target word, which are further selected through using some lexical processing tools.
 - Some tips on context windows:
   - 1-3 focus on syntax
   - 4-10 captures semantics

### Latent Semantic indexing
- LSI is one of the most classical methods for learning a low-demensional dense representation.
- mathematically, the method is just singular value decomposition: 
$$
 X_{m*n} = U_{m*k} * D_{k*k} * V_{n*k}^T
$$
    - $X_{m*n}$ is a m * n document-term matrix where m represents the number of documents and n represents the number of terms
    - $U_{m*k}$ is a m * k matrix. Each row of $U$ is a $k$-dimensional vector related to a document.
    - $D_{k*k}$ is a k * k diagonal matrix.
    - $V_{n*k}^T$ is a k * n matrix. Each column of $V^T$ is a $k$-dimensional vector related to a term.
- Using the result, lSI computes document vectors and term vectors:
  -  document vectors: $U_{m*k} D_{k*k}$  
  -  term vectors: $ V_{n*k} D_{k*k}$
- We can use the document vectors and term vectors calculate:
  -  Between-documents similarity: $U_{m*k} D_{k*k}^2 U_{m*k}^T$
  -  Between-terms similarity: $V_{n*k} D_{k*k}^2 V_{m*k}^T$

 

## Predictive Word Embedding Models
- They perform prediction tasks formulated based on word co-occurrence information. For instance
  - Whether a word appears in a context of a target word
  - or how many times a word appears in the context texts of a target word.
- Examples for training such a predictor are words and their context in a text corpus.
- Representative models include
  -  continuous bag-of-word model,
  -  skip-gram model,
  -  GloVe model


### continuous bag-of-word model

It takes context as input and target word as output: 
For example: 

example : "large scale **singular** value computation" ("singular" is target word and the others are context words)


This example gives the following training sample(input, output):
({large,scale,value,computation},singular class)

![picture1](images/截屏2022-11-10%2020.28.23.png)

- The whole model is trained to be able to classify each set of context words to its target word.
- Assume there is a total of $V$ words in the vocabulary, then we are dealing a $V$-class classification task.
- The input of each sample contains C context words. (we will fix the window size)
- $W_{V * N}$ means a word embedding matrix containing $N$-dimensional embedding vectors for a total of $V$ words in the vocabulary.

$h_i$ is feature extraction component, where:
-  $h_i = 1/C \sum_{j = 1}^{C}{x_{jk} W_{V*N}}$ ($k$ is the k-th training sample)
  

### Skip-Gram Model
![picture2](images/截屏2022-11-11%2018.18.27.png)

### Glove Model
- Both CBOW and skip-gram models are base on whether two words occurs in each other's context.
  - they does not take number of times two words occurs in each other's context into consideration.

# week 6 homework
![question1](images/截屏2022-11-11%2013.20.17.png)
a) 
||matrix|factorization|natural language|processing|
|---|---|---|---|---|
|doc1|1|1|0|0|
|doc2|1|1|0|0|
|doc3|0|0|1|1|
|doc4|0|0|1|1|
|doc5|1|1|0|1|

b) 

Calculate similarity using inner product:

function: 
$$
S_{inner}(p,q) = \sum_{i = 1}{p_i * q_i}
$$
  - "matrix" and "factorization", the similarity is:
    - $1 * 1 + 1 * 1 + 0 * 0 + 0 * 0 + 1 * 1 = 3$
  - "matrix" and "processing", the similarity is:
    - $1 * 0 + 1 * 0 + 0 * 1 + 0 * 1 + 1 * 1 = 1$

Calculate similarity using cosine function:
$$
S_{cos}(p,q) = \frac{\sum_{i=1}^{d}{p_i * q_i} }{\sqrt{\sum_{i=1}^{d}{p_i}} * \sqrt{\sum_{i=1}^{d}{q_i}}}
$$
  - "matrix" and "factorization", the cosine similarity is:
    - $ (3 / (\sqrt{1^2 + 1 ^ 2 + 0^2 + 0^2 + 1 ^ 2} * \sqrt{1^2 + 1^2 + 0^2 + 0^2 + 1^2})) = 1$
  - "matrix" and "processing", the cosine similarity is:
    - $ (1 / 3) = 1/3$
  
c)
 {large, scale, matrix, factorization, algorithm, software,
non-negative, develop, introduction, module, natural, language, processing,
linear, algebra, sparse}
term-context matrix is:
||large|scale|matrix|factorization|algorithm|software|non_negative|develop|introduction|module|natural|language|processing|linear|algebra|sparse|
|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
|matrix|1|1|3|2|1|0|1|0|0|0|0|0|1|0|0|1|
|factorization|0|1|2|3|1|0|1|0|0|0|0|0|0|0|0|0|
|natural language|0|0|0|0|0|0|0|0|0|1|0|0|2|0|0|0|
|processing|0|0|1|0|0|0|0|0|0|0|2|2|3|0|0|1|

- "matrix" and "factorization" cosine similarity is:
  -  $15 / \sqrt{19} * \sqrt{16} = 0.86$
  -  $7 / \sqrt{19} * \sqrt{19} = 0.37 $
   
Question2:
![question 2](/images/截屏2022-11-11%2016.35.45.png)

```python
import numpy as np
from numpy import array
from numpy.linalg import svd,matrix_rank
from numpy import dot
from numpy.linalg import norm
dtm = np.array([[1,1,0,0],
               [1,1,0,0],
               [0,0,1,1],
               [0,0,1,1],
               [1,1,0,1]])
u,d,v = svd(dtm)
#find how many columns are unique
k = matrix_rank(dtm)
U = u[:,:k]
V = v[:,:k]
D = np.diag(d)[:k,:k]

def cosine(a,b):
    return dot(a, b) / (norm(a) * norm(b))
#document vector and term vector
document_vector = np.matmul(U,D)
term_vector = np.matmul(V,D)
#get term vector for each term
v_matrix = term_vector[0]
v_factorization = term_vector[1]
v_nl = term_vector[2]
v_p = term_vector[3]

print(cosine(v_matrix, v_factorization))
print(cosine(v_matrix, v_nl))
```