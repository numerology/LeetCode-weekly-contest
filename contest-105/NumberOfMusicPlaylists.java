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