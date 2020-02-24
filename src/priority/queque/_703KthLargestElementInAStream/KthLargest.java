package priority.queque._703KthLargestElementInAStream;

import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> array;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.array = new PriorityQueue<>(k);
        for (int v : nums) {
            add(v);
        }
    }

    public int add(int val) {
        if (array.size() < k) {
            array.offer(val);
        } else {
            if (val > array.peek()) {
                array.poll();
                array.offer(val);
            }
        }
        return array.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
