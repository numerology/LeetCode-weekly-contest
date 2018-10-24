class Solution {
    public int minFlipsMonoIncr(String S) {
        // A O(n) solution which is easy to see
        // is by scanning for the bounday between 0 and 1
        
        int n = S.length();
        int[] nLeftOnes = new int[n]; // inclusive
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(S.charAt(i) == '1') {
                cnt++;
            }
            nLeftOnes[i] = cnt;
        }
        
        // scan for best partition
        // if we split to the right hand side of ith element
        // we need to flip all the left ones = nLeftOnes[i]
        // + all the right zeros = (n - nLeftOnes[n - 1]) - ((i + 1) - nLeftOnes[i])
        // corner case is flip all the zeros to one
        // that is (n - nLeftOnes[n - 1])
        
        int cMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cMin = Math.min(cMin, nLeftOnes[i] + (n - nLeftOnes[n - 1]) - ((i + 1) - nLeftOnes[i]));
        }
        cMin = Math.min(cMin, n - nLeftOnes[n - 1]);
        
        return cMin;
        
    }
}