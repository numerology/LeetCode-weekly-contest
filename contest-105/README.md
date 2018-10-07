
## Number of Music Playlists

The existing DP solutions from discussion threads are cleaner and less vulnerable to overflow, but if those are a bit of hard to follow, hope my solution can help you out :)

The problem contains two requirements:
1. Every song is played at least once.
2. A song can only be played again only if K other songs have been played.

Let us first deal with the 2nd requirement. Suppose L <= K, the answer should be N * (N - 1) * (N - 2) * ... * (N - L + 1). When L > K, for each new position, we will be able to reuse one of the songs in the first K places, but to fill the position, a song will be used and get blocked for another K period. Thus after L > K, we always have (N - K) options for each position, which means the answer should be N * (N - 1) * (N - 2) * ... * (N - L + 1) * (N - L + 1)^(L - K).

Then for the first requirement, we use inclusion-exclusion principle. The idea is: # of arrangements using all N songs = # of arrangements using <= N songs - (N choose N - 1) * # of arrangements using <= (N - 1) songs + (N choose N - 2) * # of arrangements using <= (N - 2) songs + ...

Code:
```
import java.math.BigInteger;
class Solution {
    int kMod = (int)1e9 + 7;
    public int numMusicPlaylists(int N, int L, int K) {
        // dp
        long[] dp = new long[N + 1];
        for (int n = K + 1; n <= N; n++) {
            long prod = 1;
            for (int l = 1; l <= L; l++) {
                if (l <= K) {
                    prod *= n - l + 1;
                    prod = prod % kMod;
                } else {
                    prod *= n - K;
                    prod = prod % kMod;
                }
                
            }
            dp[n] = (prod + kMod) % kMod;
        }
        
        long result = dp[N];
        
        for (int def = 1; def < N - K; def++) {
            if (def % 2 == 1) {
                result -= (nchoosek(N, def) * dp[N - def]) % kMod;
                result = (result + kMod) % kMod;
            } else {
                result += (nchoosek(N, def) * dp[N - def]) % kMod;
                result = (result + kMod) % kMod;
            }
        }
        
        return (int) (result + kMod) % kMod;
    }
    
    // Spent some time to debug this part.
    public long nchoosek(int n, int k) {
        BigInteger upper = new BigInteger("1");
        for (int i = 0; i < k; i++) {
            upper = upper.multiply(new BigInteger(Integer.toString(n - i)));
        }
        for (int i = 0; i < k; i++) {
             upper = upper.divide(new BigInteger(Integer.toString(k - i)));
        }
        return upper.mod(new BigInteger(Integer.toString(kMod))).longValue();
    }
}
```
