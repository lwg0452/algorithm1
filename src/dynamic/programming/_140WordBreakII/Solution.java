package dynamic.programming._140WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (!canBreak(s, wordDict)) {
            return new ArrayList<>();
        }
        int len = s.length();
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        Set<String> dict = new HashSet<>();
        for (String string : wordDict) {
            dict.add(string);
            maxLen = Math.max(maxLen, string.length());
            minLen = Math.min(minLen, string.length());
        }
        List<String>[] dp = new ArrayList[len + 1];
        dp[0] = new ArrayList<>();
        dp[0].add("");
        for (int i = 1; i <= len; i++) {
            dp[i] = new ArrayList<>();
            for (int j = minLen; j <= i && j <= maxLen; j++) {
                String sub = s.substring(i - j, i);
                if (dict.contains(sub) && !dp[i - j].isEmpty()) {
                    for (String string : dp[i - j]) {
                        dp[i].add(string + (string == "" ? "" : " ") + sub);
                    }
                }
            }
        }
        return dp[len];
    }

    public boolean canBreak(String s, List<String> wordDict) {
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