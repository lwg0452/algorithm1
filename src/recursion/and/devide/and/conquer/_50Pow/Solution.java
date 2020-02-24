package recursion.and.devide.and.conquer._50Pow;

class Solution {
    public static double myPow(double x, int n) throws IllegalArgumentException {
        if (x == 0 && n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1 || x == 1) {
            return x;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / x * (1 / myPow(x, -(n + 1)));
            }
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
        double temp = myPow(x, (n - 1) / 2);
        return x * temp * temp;
    }
}