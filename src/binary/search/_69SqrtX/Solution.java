package binary.search._69SqrtX;

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        int right = x;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (mid < x/mid) {
                left = mid + 1;
            } else if (mid > x/mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return (left + right) / 2;
    }
}
