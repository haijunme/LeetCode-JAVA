package main.quickpractices.dynamicprogramming.greedy;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {
        int totalCost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // add all sticks to the min heap.
        for (int stick : sticks) {
            pq.add(stick);
        }
        // combine two of the smallest sticks until we are left with just one.
        while (pq.size() > 1) {
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            int cost = stick1 + stick2;
            totalCost += cost;
            pq.add(stick1 + stick2);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        var solution = new MinimumCostToConnectSticks();
        System.out.println(solution.connectSticks(new int[]{3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}));
    }
}
