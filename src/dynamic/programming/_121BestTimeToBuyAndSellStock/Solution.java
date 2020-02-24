package dynamic.programming._121BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices == null || prices.length == 0) {
            return res;
        }
        int lowestPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - lowestPrice > res) {
                res = prices[i] - lowestPrice;
            } else if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }
        return res;
    }
}
