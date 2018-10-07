class Solution {
    public int maxSubarraySumCircular(int[] A) {
        // key idea is that,
        // every subarray crossing the first element
        // has a sum = total sum - its complement
        // other part is completely the same
        
        int n = (A == null) ? 0 : A.length;
        if (n == 0) return 0;
        
        int[] cumSum = new int[n]; // cumulative sum for A[0:i] inclusive
        int cSum = 0;
        for (int i = 0; i < n; i++) {
            cSum += A[i];
            cumSum[i] = cSum;
        }
        
        int total = cumSum[n - 1];
        
        int cMin = 0;
        int cMax = cumSum[0];
        
        int result = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            result = Math.max(result, cumSum[i] - cMin);
            result = Math.max(result, total - (cumSum[i] - cMax));
            
            cMin = Math.min(cMin, cumSum[i]);
            cMax = Math.max(cMax, cumSum[i]);
        }
        
        return result;
        
    }
}