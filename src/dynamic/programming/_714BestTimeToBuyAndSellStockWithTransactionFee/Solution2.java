package dynamic.programming._714BestTimeToBuyAndSellStockWithTransactionFee;

class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int[] have = new int[prices.length];
        int[] noHave = new int[prices.length];
        have[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            noHave[i] = Math.max(noHave[i - 1], have[i - 1] + prices[i] - fee);
            have[i] = Math.max(have[i - 1], noHave[i - 1] - prices[i]);
        }
        return noHave[prices.length-1];
    }
}
