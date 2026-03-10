class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int maxProfit = 0;
        for(int r = 1; r < prices.length; r++){
            if(prices[r] < prices[l]){
                l = r;
            }
            else{
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
