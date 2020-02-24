package hash.table.and.set._18FourSum;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[nums.length - 1] * 3 < target) {
                continue;
            }
            if (nums[i] * 4 > target) {
                break;
            }
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] * 2 < target) {
                    continue;
                }
                if (nums[i] + nums[j] * 3 > target) {
                    break;
                }
                int expectedSum = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == expectedSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (nums[left] + nums[right] < expectedSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
