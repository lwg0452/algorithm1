package binary.search._367ValidPerfectSquare;

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        int l = 1;
        int r = num;
        int res;
        while (l <= r) {
            res = (l + r) / 2;
            if (res == num / (double)res) {
              return true;
            } else if (res < num / res) {
                l = res + 1;
            } else {
                r = res - 1;
            }
        }
        return false;
    }
}
