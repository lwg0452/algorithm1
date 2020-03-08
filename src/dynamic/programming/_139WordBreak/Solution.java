package dynamic.programming._139WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        dp[0] = true;
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && j <= maxLen; j++) {
                if (dp[i - j] && dict.contains(s.substring(i-j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
