class Solution {
    public int[] threeEqualParts(int[] A) {
        // Three parts must contain the same number of 1s
        // say there are 3k 1s
        // consider how to arrange zeros to split them
        // watch for the pos of 0th, kth and 2kth 1
        int n = A.length;
        int nOnes = 0;
        for(int i : A) {
            if (i == 1) nOnes ++;
        }
        int k = 0;
        if (nOnes == 0) {
            return new int[]{0, n - 1};
        }
        if (nOnes % 3 != 0) {
            return new int[]{-1, -1};
        } else {
            k = nOnes / 3;
        }
        // find 2kth 1
        int cnt = 0;
        int criticalPos = 0;
        int zeroth = 0;
        int kth = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                if(cnt == 0) {
                    zeroth = i;
                }
                if(cnt == k) {
                    kth = i;
                }
                if(cnt == 2 * k) {
                    criticalPos = i;
                    break;
                }
                cnt++;
            }
        }
        
        int[] sample = new int[n - criticalPos];
        for (int i = criticalPos; i < n; i++) {
            sample[i - criticalPos] = A[i];
        }
        
        int tailing0 = 0;
        int m = sample.length;
        for (int i = m - 1; i >= 0; i--) {
            if (sample[i] == 1) break;
            tailing0 ++;
        }
        // if the second part want to be equas
        // its last ones must be separated against criticalPos by
        // at least the number of tailing 0 sample has
        /**
        int 2tailing0 = 0;
        for (int i = criticalPos - 1; i>=0 ; i--) {
            if (sample[i] == 1) break;
            2tailing0 ++;
        }
        if (2tailing0 < tailing0) {
            return new int[]{-1, -1};
        }
        */
        // compare the first part
        for (int i = zeroth; i < zeroth + m; i++) {
            if (sample[i - zeroth] != A[i]) {
                System.out.println("mismatch in first part");
                return new int[]{-1, -1};
            }
        }
        
        for (int i = kth; i < kth + m; i++) {
            if (sample[i - kth] != A[i]) {
                System.out.println("mismatch in second part");
                return new int[]{-1, -1};
            }
        }
        
        
        return new int[]{zeroth + m - 1 , kth + m};
        
    }
}