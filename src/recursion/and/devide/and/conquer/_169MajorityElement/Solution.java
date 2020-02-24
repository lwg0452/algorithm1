package recursion.and.devide.and.conquer._169MajorityElement;

import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        Integer majority = nums[0];
        int couont = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int n = map.get(nums[i]) + 1;
                if (n > couont) {
                    couont = n;
                    majority = nums[i];
                }
                map.put(nums[i], n);
            } else {
                map.put(nums[i], 1);
            }
            if (couont > nums.length / 2) {
                return majority;
            }
        }
        return majority;
    }
}
