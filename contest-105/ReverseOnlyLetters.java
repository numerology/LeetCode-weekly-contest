class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        
        int n = (S == null) ? 0: S.length();
        if (n == 0) return "";
        for (int i = 0; i < n; i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                stack.push(S.charAt(i));
            }
        }
        
        for (int i = 0; i < n; i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                sb.append(stack.pop());
            } else {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
        
    }
}