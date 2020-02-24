package bit.operation._338CountingBits;

class Solution2 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            //i&(i-1)清零i最后一位的1，该数比i小，已经计算过了，i比该数多一个1
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
