package LEETCODE.JAVA;

public class stocks {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices){
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res += Math.max(0, prices[i] - prices[i-1]);
        }
        return res;   
    }
}
