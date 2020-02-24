package dynamic.programming._309BestTimeToBuyAndSellStockWithCooldown;

class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] have = new int[prices.length];
        int[][] noHave = new int[prices.length][2]; //noHave[i][0]表示第i天没卖股票，noHave[i][1]表示第i天卖股票了
        have[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            have[i] = Math.max(have[i - 1], noHave[i - 1][0] - prices[i]);
            noHave[i][0] = Math.max(noHave[i - 1][0], noHave[i - 1][1]);
            noHave[i][1] = have[i - 1] + prices[i];
        }
        return Math.max(noHave[prices.length - 1][0], noHave[prices.length - 1][1]);
    }
}
