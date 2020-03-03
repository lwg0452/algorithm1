package dynamic.programming._91DecodeWays;

class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            char one = s.charAt(i - 1);
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one != '0') {
                dp[i] += dp[i - 1];
            } else {
                if (s.charAt(i - 2) > '2' || s.charAt(i - 2) == '0') {
                    return 0;
                }
            }
            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
