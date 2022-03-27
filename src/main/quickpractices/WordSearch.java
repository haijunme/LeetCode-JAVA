package main.quickpractices;

import java.util.*;

public class WordSearch {

    public boolean backtracking(String word, int index, Map<Character, List<int[]>> posMap, List<int[]> existingPath) {
        if (index >= word.length()) {
            return true;
        }
        List<int[]> possiblePos =  posMap.get(word.charAt(index));
        for (int[] pos : possiblePos) {
            if (existingPath.size() > 0) {
                int[] lastNode = existingPath.get(index - 1);
                int posDiff = Math.abs(pos[0] - lastNode[0]) + Math.abs(pos[1] - lastNode[1]);
                if (!existingPath.contains(pos) && posDiff == 1) {
                    existingPath.add(pos);
                    if (backtracking(word, index + 1, posMap, existingPath)) {
                        return true;
                    }
                    existingPath.remove(pos);
                }
            } else {
                existingPath.add(pos);
                if (backtracking(word, index + 1, posMap, existingPath)) {
                    return true;
                }
                existingPath.remove(pos);
            }
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        Map<Character, List<int[]>> pos = new HashMap<>();
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (pos.get(board[i][j]) == null) {
                    pos.put(board[i][j], new ArrayList<int[]>());
                }
                pos.get(board[i][j]).add(new int[]{i, j});
            }
        }
        for (int i = 0; i < word.length(); i ++) {
            if (pos.get(word.charAt(i)) == null) {
                return false;
            }
        }
        return backtracking(word,0, pos, new ArrayList<>());
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'},{'A','A','A','A','A','A'}};
        String word = "AAAAAAAAAAAAAAB";
        WordSearch solution = new WordSearch();
        System.out.println(solution.exist(board, word));
    }
}
