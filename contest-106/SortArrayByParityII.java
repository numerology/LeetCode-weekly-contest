class Solution {
    public int[] sortArrayByParityII(int[] A) {
        // Simplest way to write
        int n = (A == null) ? 0 : A.length;
        if (n == 0 || n % 2 != 0) return null;
        int ePtr = 0, oPtr = 1;
        int[] result = new int[n];
        for(int a : A) {
            if(a % 2 == 0) {
                result[ePtr] = a;
                ePtr+=2;
            } else {
                result[oPtr] = a;
                oPtr+=2;
            }
        }
        return result;
    }
}