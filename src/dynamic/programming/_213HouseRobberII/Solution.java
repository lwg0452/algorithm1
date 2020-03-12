package dynamic.programming._213HouseRobberII;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[][] dp = new int[len + 1][2];
        dp[1][1] = nums[0];
        for (int i = 2; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i - 1]);
        }
        dp[len][0] = Math.max(dp[len - 1][0], dp[len - 2][0] + nums[len - 1]);
        dp[len][1] = dp[len - 1][1];
        return Math.max(dp[len][0], dp[len][1]);
    }
}
