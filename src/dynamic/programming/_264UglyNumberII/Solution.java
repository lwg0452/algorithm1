package dynamic.programming._264UglyNumberII;

class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int count2 = 0, count3 = 0, count5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(Math.min(factor2, factor3), factor5);
            if (ugly[i] == factor2) {
                count2++;
                factor2 = 2 * ugly[count2];
            }
            if (ugly[i] == factor3) {
                count3++;
                factor3 = 3 * ugly[count3];
            }
            if (ugly[i] == factor5) {
                count5++;
                factor5 = 5 * ugly[count5];
            }
        }
        return ugly[n - 1];
    }
}
