---
title: week 7 NLP speech Sysnthesis and Recognition
tags: NLP
category: NLP

---

## Speech Sysnthesis
Text-to-speech sysnthesis is a task that takes a sequence of text words and producing an acoustic ware as output.

- sound waves   
  - the sound that we hear is a complext series of changes in air pressure
  - two important feature of a ware is its frequency and amplitude(the loudness of the sound)
  
- representation of sound wave
  - Fourier transform(傅立叶转换) can be used to seperate out each of the frequency components that a wave contains.
  - spectrogram(声谱图) shows how different frequencies, which make up a sound wave, change over time.
  - formants(共振峰) is the dark horizontal bar in sepectrogram, it represents spectral peaks,usually of vowels. It is the distinctive frequency components of acoustic signal.

Phones and Phonemes
- phone:
    - phone is a speech sound
    - phones are divided into vowels and consonants.
    -  vowels and consonants are combined together to make a syllable(音标)
    -  articulatory phonetics(发音语音学): the study that how phone produced
- phoneme:
  - phones are often produced differently in different contexts.
    - example: [t] tunafish , starfish
  - An allophone(音位变体) is one of a set of multiple possible spoken sounds.
  - phoneme is a generalization or abstraction of different phonetic realization.




### How to build text-to-speech
- A naive way, from pronounce dictionary.
- other technology: 
  - apply rules



- Prosody(重音和语调结构， 韵律学)
  - prosody modelling: 
    - prosody is implemenetd by adjusting **rate, intensity, duration and pitch(related to frequency) parameters**
suprasegmental phenomena(超音段现象)


Text-to-speech Pipline
- A sequence to sequenxe mapping problem
- step1: Text analysis
  - input is text
  - output:a phoneme(音位) sequence with a variety of linguistic contexts called linguistic specification
- step2: Speech Sysnthesis
  -  input: linguistic specification
  -  output: sysnthesized sound wave (include prosody prediction and speech waveform generation)

Speech Sysnthesis techniques
- A speech synthesizer produces, e.g., an output sequence of phones(sound), each with a duration and specified putch, for a input linguistic specification.
- techiniques:
  -  concatenative speech synthesis:
     -   core idea: Glue together speech chunks that have been previously recorded. 
     -  two types of concatenation: 
        -  fixed invetory
        -  unit selection 
  - parameter speech synthesis
  - end to end, 


## Speech Recognition

Challenge: It is not possible to treat waveform, as a sequence of concatenated static patterns.



Multidisciplinary Research

Speech Recognition System Architecture
- input speech
- put the speech into Feature Extraction and generate **Feature Vectors**
- then put the feature vector into Decoder and it will generate the output

Feature Extraction:
- input: continuous input sound wave
  - First, signal digitisation by sampling and quantisation
  - Second, spectral(频谱的) feature extraction from the quantised signal samples.
- output: a sequence of speech feature vectors. 

Decoding: 
- To decode the sequence of feature vectors to a sentence containing a sequence of words.
  - cosider all sentences possible
  - calculate the possibilty
  - choose the sentence with maximum possibility
- Two problems to solve:
  - A metric for a "best match" is needed
  - select a good algorithm to find the sentence has good match of the input. 

Probability Based "Best Matching"
- represent an observed spoken sentence by a sequence of speech vectors: 
  $O = o_1,o_2,...,o_T$
- represent a candidate sentence(e.g., a sequence of word symbols) as:
- $W = w_1, w_2, ..., w_n$
- The best matching sentence is:
  $$ 
  \begin{aligned}
  \hat{W} &= \mathop{argmax P}\limits_{w}(W|O) \\
          &= \mathop{argmax}\limits_{w} \frac{P(O|W) P(W)}{P(O)} \quad  \text{by using Bayes' rule}\\
          &= \mathop{argmax}\limits_{w} P(O|W) P(W) \quad \text{it is hard to estimate} \quad P(O), \text{but it will not change anything} \\
    & P(O|W) \text{is acoustic model}
   \end{aligned}$$

### HMM  隐性马卡罗夫模型
参数要求：
  - s 