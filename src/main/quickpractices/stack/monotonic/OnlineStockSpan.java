package main.quickpractices.stack.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    //@formatter:off
    private static class StockSpanner {
        private static class Pair {
            private int value;
            private int consecutiveDays;
            private Pair(int value, int consecutiveDays) {
                this.value = value;
                this.consecutiveDays = consecutiveDays;
            }
        }
        //@formatter:on
        final Deque<Pair> prices;

        public StockSpanner() {
            prices = new ArrayDeque<>();
        }

        public int next(int price) {
            int consecutiveDays = 1;
            while (!prices.isEmpty() && prices.peekLast().value <= price) {
                consecutiveDays += prices.removeLast().consecutiveDays;
            }
            prices.addLast(new Pair(price, consecutiveDays));
            return consecutiveDays;
        }
    }

    public static void main(String[] args) {
        var stockSpanner  = new StockSpanner();
        stockSpanner.next(100); // return 1
        stockSpanner.next(80);  // return 1
        stockSpanner.next(60);  // return 1
        stockSpanner.next(70);  // return 2
        stockSpanner.next(60);  // return 1
        stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        stockSpanner.next(85);  // return 6
    }
}
