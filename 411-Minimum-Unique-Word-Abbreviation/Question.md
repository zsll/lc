# 411. Minimum Unique Word Abbreviation

[Original Page](https://leetcode.com/problems/minimum-unique-word-abbreviation/)

A string such as `"word"` contains the following abbreviations:

<pre>["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
</pre>

Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the **_smallest possible_** length such that it does not conflict with abbreviations of the strings in the dictionary.

Each **number** or letter in the abbreviation is considered length = 1\. For example, the abbreviation "a32bc" has length = 4.

**Note:**  

*   In the case of multiple answers as shown in the second example below, you may return any one of them.
*   Assume length of target string = **m**, and dictionary size = **n**. You may assume that **m ≤ 21**, **n ≤ 1000**, and **log<sub>2</sub>(n) + m ≤ 20**.

**Examples:**  

<pre>"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
</pre>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Show Company Tags</div>

<span class="hidebutton">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Backtracking](/tag/backtracking/) [Bit Manipulation](/tag/bit-manipulation/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Show Similar Problems</div>

<span class="hidebutton">[(M) Generalized Abbreviation](/problems/generalized-abbreviation/) [(E) Valid Word Abbreviation](/problems/valid-word-abbreviation/)</span></div>