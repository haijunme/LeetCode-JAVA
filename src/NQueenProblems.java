import java.util.Arrays;

public class NQueenProblems {
    private static void printSolution(char[][] mat) {
        for (char[] chars: mat) {
            System.out.println(Arrays.toString(chars).replaceAll(",", ""));
        }
    }

    public static void nQueens(char[][] mat, int row) {
        if (row == 9) {
            printSolution(mat);
            return;
        }
        for (int i = 0; i < mat.length; i++) {
            mat[row][i] = 'Q';

        }
    }


    public static void main(String[] args) {
        int N = 9;
        char[][] mat = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '-');
        }
        nQueens(mat, 0);
    }
}
