class Solution {
    public int maxProfit(int[] prices) {
        int[] maxPrice = new int[prices.length];
        int maxSoFar = 0;
        for(int i = prices.length-1; i >= 0; i--) {
            maxSoFar = Math.max(prices[i], maxSoFar);
            maxPrice[i] = maxSoFar;
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, maxPrice[i]-prices[i]);
        }

        return maxProfit;
    }
}