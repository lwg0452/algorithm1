package priority.queque._239SlidingWindowMaximum;

class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        res[0] = nums[maxIndex];
        for (int left = 1; left <= nums.length - k; left++) {
            int right = left + k - 1;
            if (nums[right] > nums[maxIndex]) {
                maxIndex = right;
            } else if (left > maxIndex) {
                maxIndex = left;
                for (int i = left + 1; i < left + k; i++) {
                    if (nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
            res[left] = nums[maxIndex];
        }
        return res;
    }
}
