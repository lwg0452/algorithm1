package dynamic.programming.LongestIncreasingSubsequence;

class Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j]+1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }
}
