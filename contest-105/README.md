## Reverse Only Letters

Just scan the string and store the letters in a stack, then build the result accordingly.

## Maximum Sum Circular Subarray

This is closely related to LC 53. Note that, if we are restricted to the case where subarray cannot cross the boundary of the array then they are exactly the same. So the problem is how to tracking those subarrays when they are crossing the boundary. This can be done by using: Sum of subarray = total sum - sum of its complement. Where complement is the subarray including all the elements not included by the subarray.

## CBT inserter.

I borrowed the idea from [Geeksforgeeks: linked CBT creation](https://www.geeksforgeeks.org/linked-complete-binary-tree-its-creation/).

One difference here: when creating the CBT, we use a queue to do DFS, and when current node do not have two children, push them to the CBT queue, which is different than the dfs queue.

## Number of Music Playlists

The existing DP solutions from discussion threads are cleaner and less vulnerable to overflow, but if those are a bit of hard to follow, hope my solution can help you out :)

The problem contains two requirements:
1. Every song is played at least once.
2. A song can only be played again only if K other songs have been played.

Let us first deal with the 2nd requirement. Suppose L <= K, the answer should be N * (N - 1) * (N - 2) * ... * (N - L + 1). When L > K, for each new position, we will be able to reuse one of the songs in the first K places, but to fill the position, a song will be used and get blocked for another K period. Thus after L > K, we always have (N - K) options for each position, which means the answer should be N * (N - 1) * (N - 2) * ... * (N - K + 1) * (N - K)^(L - K).

Then for the first requirement, we use inclusion-exclusion principle. The idea is: # of arrangements using all N songs = # of arrangements using <= N songs - (N choose N - 1) * # of arrangements using <= (N - 1) songs + (N choose N - 2) * # of arrangements using <= (N - 2) songs + ...

---------------------
Editing to see how PR works here
