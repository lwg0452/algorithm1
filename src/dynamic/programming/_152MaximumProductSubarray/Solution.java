package dynamic.programming._152MaximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (dp[i] > res) {
                res = dp[i];
            }
            for (int j = i + 1; j < nums.length; j++) {
                dp[j] = dp[j-1] * nums[j];
                if (dp[j] > res) {
                    res = dp[j];
                }
            }
        }
        return res;
    }
}
