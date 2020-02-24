package dynamic.programming._70ClimbingStairs;

class Solution2 {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int pre = 1;
        int res = 2;
        for (int i = 2; i < n; i++) {
            int temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }
}
