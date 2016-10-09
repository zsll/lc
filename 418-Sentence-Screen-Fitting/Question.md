# 418. Sentence Screen Fitting

[Original Page](https://leetcode.com/problems/sentence-screen-fitting/)

Given a `rows x cols` screen and a sentence represented by a list of words, find **how many times** the given sentence can be fitted on the screen.

**Note:**

1.  A word cannot be split into two lines.
2.  The order of words in the sentence must remain unchanged.
3.  Two consecutive words **in a line** must be separated by a single space.
4.  Total words in the sentence won't exceed 100.
5.  Length of each word won't exceed 10.
6.  1 ≤ rows, cols ≤ 20,000.

**Example 1:**

<pre>**Input:**
rows = 2, cols = 8, sentence = ["hello", "world"]

**Output:** 
1

**Explanation:**
hello---
world---

The character '-' signifies an empty space on the screen.
</pre>

**Example 2:**

<pre>**Input:**
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

**Output:** 
2

**Explanation:**
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
</pre>

**Example 3:**

<pre>**Input:**
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

**Output:** 
1

**Explanation:**
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
</pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Dynamic Programming](/tag/dynamic-programming/)</span></div>