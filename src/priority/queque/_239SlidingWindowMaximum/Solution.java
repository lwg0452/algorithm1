package priority.queque._239SlidingWindowMaximum;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                res[i - k] = queue.peek();
                queue.remove(nums[i-k]);
                queue.offer(nums[i]);
            }
        }
        res[nums.length - k] = queue.poll();
        return res;
    }
}
