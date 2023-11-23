package main.prep2021.quickpractices.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class DesignHitCounter {
    private static class HitCounter {
        private final List<int[]> hits;

        public HitCounter() {
            this.hits = new ArrayList<>();
        }

        // prefix sum technique to handle duplicated hit counts
        public void hit(int timestamp) {
            if (hits.isEmpty()) {
                hits.add(new int[]{timestamp, 1});
            } else if (hits.get(hits.size() - 1)[0] == timestamp) {
                hits.get(hits.size() - 1)[1]++;
            } else {
                hits.add(new int[]{timestamp, 1 + hits.get(hits.size() - 1)[1]});
            }
        }

        // ordinary binary search, except returning "supposed index" when element not found
        private int binarySearch(int target) {
            int left = 0;
            int right = hits.size() - 1;
            while (left <= right) {
                int mid = left + (right - left)/2;
                if (hits.get(mid)[0] == target) {
                    return mid;
                } else if (hits.get(mid)[0] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        // unfortunate complexity because of left border handling, please let me know if you have
        // ways to improve this
        public int getHits(int timestamp) {
            int sixMinsAgo = timestamp - 300;
            int leftCount;
            int tailIndex = hits.size() - 1;
            if (hits.size() == 0 || sixMinsAgo >= hits.get(tailIndex)[0]) {
                return 0;
            } else if (sixMinsAgo < hits.get(0)[0]) {
                leftCount = 0;
            } else if (sixMinsAgo == hits.get(0)[0]) {
                leftCount = hits.get(0)[1];
            } else {
                int leftIndex = binarySearch(sixMinsAgo);
                if (leftIndex == tailIndex) {
                    return hits.get(leftIndex)[1] - (hits.size() == 1 ? 0 : hits.get(leftIndex - 1)[1]);
                } else {
                    if (hits.get(leftIndex)[0] == sixMinsAgo) {
                        leftCount = hits.get(leftIndex)[1];
                    } else {
                        leftCount = hits.size() == 1 ? 0 : hits.get(leftIndex - 1)[1];
                    }
                }
            }
            return hits.get(tailIndex)[1] - leftCount;
        }
    }

    public static void main(String[] args) {
        var solution = new HitCounter();
        solution.hit(100);
        solution.hit(282);
        solution.hit(411);
        solution.hit(609);
        solution.hit(620);
        solution.hit(744);
        System.out.println(solution.getHits(879));
       // System.out.println(solution.getHits(301));
        //System.out.println(solution.getHits(302));
       // System.out.println(solution.getHits(303));
        //System.out.println(solution.getHits(304));
//        solution.hit(501);
//        System.out.println(solution.getHits(600));
    }
}
