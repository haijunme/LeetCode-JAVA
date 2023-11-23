package main.prep2021.quickpractices.array;

import java.util.*;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // initialize trackers, O(n)
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> columns = new ArrayList<>(9);
        List<Set<Character>> subBoards = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            subBoards.add(new HashSet<>());
        }

        // iterations, O(n)/constant runtime?
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (!Character.isDigit(digit)) {
                    continue;
                }
                if (!rows.get(i).add(digit)
                        || !columns.get(j).add(digit)
                        || !subBoards.get((i / 3) * 3 + j / 3).add(digit)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
