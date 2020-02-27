package dynamic.programming._5LongestPalindromicSubstring;

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int subLen = 2; subLen <= len; subLen++) {
            for (int i = 0; i <= len - subLen; i++) {
                int j = i + subLen - 1;
                if (s.charAt(i) != s.charAt(j)) {
                    continue;
                }
                if (j - i == 1 || dp[i + 1][j - 1] == true) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
