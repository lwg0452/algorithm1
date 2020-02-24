package recursion.and.devide.and.conquer._53MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum;
        for (int i = 0; i < nums.length; i++) {
            currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }
}
