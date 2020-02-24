package dynamic.programming._123BestTimeToBuyAndSellStockIII;

class Solution {
    public int maxProfit(int[] prices) {
        return maxProfit(prices, 2);
    }

    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length <= 1 || k <= 0) {
            return 0;
        }
        int days = prices.length;
        int[] max = new int[k + 1]; //max[i]表示至多交易i次后持有一股的利润
        int[][] dp = new int[days + 1][k + 1]; //dp[i][j]表示第i天至多交易j次后不持有股票的利润
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