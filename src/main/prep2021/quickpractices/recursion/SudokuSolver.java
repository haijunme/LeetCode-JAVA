package main.prep2021.quickpractices.recursion;

import java.util.*;

public class SudokuSolver {
    private static final List<Character> ALL_CANDIDATES = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    private Deque<int[]> emptyCells;
    private char[][] board;
    private char[][] temporary;

    private List<Set<Character>> existingInRows;
    private List<Set<Character>> existingInColumns;
    private List<Set<Character>> existingInSubgrids;

    public static void main(String[] args) {
        var solution = new SudokuSolver();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solution.solveSudoku(board);
    }

    private int getSubgridIndex(int x, int y) {
        // {x values}/3*3 + {y values/3} = index in "existingInSubgrids"
        // {0,1,2}/3*3 = 0, 0 + {0, 1, 2} = {0,1,2}
        // {3,4,5}/3*3 = 3, 3 + {0, 1, 2} = {3,4,5}
        // {6,7,8}/3*3 = 6, 6 + {0, 1, 2} = {6,7,8}
        return x / 3 * 3 + y / 3;
    }

    private void recur() {
        int[] cell = emptyCells.pollFirst();
        // we have filled in all cells of the sudoku
        if (cell == null) {
            for (int i = 0; i < 9; i++) {
                System.arraycopy(temporary[i], 0, board[i], 0, 9);
            }
            return;
        }
        int x = cell[0];
        int y = cell[1];
        List<Character> unused = new ArrayList<>();

        Set<Character> currentRow = existingInRows.get(x);
        Set<Character> currentColumn = existingInColumns.get(y);
        Set<Character> currentSubgrid = existingInSubgrids.get(getSubgridIndex(x, y));

        for (Character unusedChar : ALL_CANDIDATES) {
            if (!currentRow.contains(unusedChar)
                    && !currentColumn.contains(unusedChar)
                    && !currentSubgrid.contains(unusedChar)) {
                unused.add(unusedChar);
            }
        }
        for (Character unusedChar : unused) {
            temporary[x][y] = unusedChar;
            currentRow.add(unusedChar);
            currentColumn.add(unusedChar);
            currentSubgrid.add(unusedChar);

            recur();

            currentRow.remove(unusedChar);
            currentColumn.remove(unusedChar);
            currentSubgrid.remove(unusedChar);
            temporary[x][y] = '.';
        }
        emptyCells.addFirst(cell);
    }

    public void solveSudoku(char[][] board) {
        // initialization
        emptyCells = new ArrayDeque<>(9 * 9);
        this.board = board;
        this.temporary = new char[9][9];
        existingInRows = new ArrayList<>();
        existingInColumns = new ArrayList<>();
        existingInSubgrids = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            existingInRows.add(new HashSet<>());
            existingInColumns.add(new HashSet<>());
            existingInSubgrids.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (Character.isDigit(current)) {
                    existingInRows.get(i).add(current);
                    existingInColumns.get(j).add(current);
                    existingInSubgrids.get(getSubgridIndex(i, j)).add(current);
                } else {
                    emptyCells.addLast(new int[]{i, j});
                }
                temporary[i][j] = current;
            }
        }
        recur();
    }
}
