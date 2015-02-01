public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int profit = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i ++) {
            profit = (profit > prices[i] - curMin) ? profit : prices[i] - curMin;
            curMin = (prices[i] < curMin) ? prices[i] : curMin;
        }

        return profit;
    }
}
