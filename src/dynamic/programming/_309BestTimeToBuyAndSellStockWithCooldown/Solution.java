package dynamic.programming._309BestTimeToBuyAndSellStockWithCooldown;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[][][] dp = new int[prices.length][2][2]; //dp[i][j][k]第i天持有i股是否,今天是否买过股票
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
        }
        return Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][0][1]);
    }
}
