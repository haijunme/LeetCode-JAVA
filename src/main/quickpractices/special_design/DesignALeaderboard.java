package main.quickpractices.special_design;

import java.util.*;

public class DesignALeaderboard {
    private static class Leaderboard {
        private final Map<Integer, Integer> board;
        List<Integer> players;

        public Leaderboard() {
            this.board = new HashMap<>();
            this.players = new ArrayList<>(10000);
        }

        // O(NLogN)
        public void addScore(int playerId, int score) {
            if (board.containsKey(playerId)) {
                board.put(playerId, board.get(playerId) + score);
            } else {
                board.put(playerId, score);
                players.add(playerId);
            }
            players.sort((a, b) -> board.get(b) - board.get(a));
        }

        // O(N)
        public int top(int K) {
            int result = 0;
            for (int i = 0; i < K && i < players.size(); i++) {
                result += board.get(players.get(i));
            }
            return result;
        }

        // O(NLogN)
        public void reset(int playerId) {
            board.put(playerId, 0);
            players.sort((a, b) -> board.get(b) - board.get(a));
        }
    }

    public static void main(String[] args) {
        var leaderboard = new Leaderboard();
        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
    }
}
