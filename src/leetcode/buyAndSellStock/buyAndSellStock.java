package leetcode.buyAndSellStock;

/*
121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
Problem link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* */

public class buyAndSellStock {
    public static void main(String[] args) {
        var prices = new int[] {7, 1, 5, 3, 6, 4};

        var maxProfit = maxProfit(prices);

        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] prices) {
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = 0;

        for(int price: prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
