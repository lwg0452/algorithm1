package dynamic.programming._188BestTimeToBuyAndSellStockIV;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <= 1 || k == 0) {
            return 0;
        }
        int days = prices.length;
        if (k >= days / 2) {
            int res = 0;
            for (int i = 1; i < days; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) {
                    res += profit;
                }
            }
            return res;
        }

        int[] max = new int[k + 1];
        int[][] dp = new int[days + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            max[i] = -prices[0];
        }
        for (int i = 1; i <= days; i++) {
            for (int j = 1; j <= k; j++) {
                max[j] = Math.max(max[j], dp[i - 1][j - 1] - prices[i - 1]);
                dp[i][j] = Math.max(dp[i - 1][j], max[j] + prices[i - 1]);
            }
        }
        return dp[days][k];
    }
}
