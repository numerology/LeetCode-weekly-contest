class Solution {
    public int minAddToMakeValid(String S) {
        // just add ( on demand so that ctr >= 0
        // and add ) in the end
        int n = (S == null) ? 0 : S.length();
        if (n == 0) return 0;
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == '(') {
                cnt++;
            } else {
                if(cnt == 0) {
                    res++;
                } else {
                    cnt--;
                }
            }
        }
        
        res += cnt;
        return res;
        
    }
}