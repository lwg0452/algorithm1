package hash.table.and.set._1TwoSum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[2];
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                res[0] = hashMap.get(target - nums[i]);
                res[1] = i;
                return res;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return res;
    }
}
