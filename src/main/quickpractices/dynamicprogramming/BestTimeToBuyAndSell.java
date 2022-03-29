package main.quickpractices.dynamicprogramming;

public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            if (price - minPrice >= maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();
        System.out.println(bestTimeToBuyAndSell.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
