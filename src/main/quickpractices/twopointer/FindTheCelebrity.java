package main.quickpractices.twopointer;

public class FindTheCelebrity {

    private static boolean knows(int a, int b) {
        return true;
    }

    private static class LogicalDeduction {
        private int numberOfPeople;

        public int findCelebrity(int n) {
            numberOfPeople = n;
            int celebrityCandidate = 0;
            for (int i = 0; i < n; i++) {
                if (knows(celebrityCandidate, i)) {
                    celebrityCandidate = i;
                }
            }
            if (isCelebrity(celebrityCandidate)) {
                return celebrityCandidate;
            }
            return -1;
        }

        private boolean isCelebrity(int i) {
            for (int j = 0; j < numberOfPeople; j++) {
                if (i == j) continue; // Don't ask if they know themselves.
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            boolean knowsNobody = true;
            boolean everybodyKnowsMe = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                knowsNobody = knowsNobody && !knows(i, j);
                everybodyKnowsMe = everybodyKnowsMe && knows(j, i);
            }
            if (knowsNobody && everybodyKnowsMe) {
                return i;
            }
        }
        return -1;
    }
}
