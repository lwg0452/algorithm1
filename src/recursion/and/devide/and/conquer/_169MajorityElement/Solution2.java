package recursion.and.devide.and.conquer._169MajorityElement;

class Solution2 {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = nums[i+1];
            }
        }
        return majority;
    }
}
