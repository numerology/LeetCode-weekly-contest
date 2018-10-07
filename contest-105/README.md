
## Number of Music Playlists

The existing DP solutions from discussion threads are cleaner and less vulnerable to overflow, but if those are a bit of hard to follow, hope my solution can help you out :)

The problem contains two requirements:
1. Every song is played at least once.
2. A song can only be played again only if K other songs have been played.

Let us first deal with the 2nd requirement. Suppose L <= K, the answer should be N * (N - 1) * (N - 2) * ... * (N - L + 1). When L > K, for each new position, we will be able to reuse one of the songs in the first K places, but to fill the position, a song will be used and get blocked for another K period. Thus after L > K, we always have (N - K) options for each position, which means the answer should be N * (N - 1) * (N - 2) * ... * (N - L + 1) * (N - L + 1)^(L - K).

Then for the first requirement, we use inclusion-exclusion principle. The idea is: # of arrangements using all N songs = # of arrangements using <= N songs - (N choose N - 1) * # of arrangements using <= (N - 1) songs + (N choose N - 2) * # of arrangements using <= (N - 2) songs + ...