import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    static void sort(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            int[] key = array[i];
            int j = i-1;
            while (j >= 0 && array[j][0] > key[0]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }

        ArrayList<int[]> resultCache = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] merged = intervals[0];
        for (int i = 1; i < intervals.length; i ++) {
            if (intervals[i][0] > merged[1]) {
                resultCache.add(merged);
                merged = intervals[i];
            } else {
                merged[1] = Math.max(intervals[i][1], merged[1]);
            }
        }
        resultCache.add(merged);
        int[][] result = new int[resultCache.size()][2];
        for (int i = 0; i < resultCache.size(); i++) {
            result[i] = resultCache.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {{15,18}, {15, 18}};
        sort(array);
        System.out.println(Arrays.toString(array));
        int[][] answer = merge(array);
        System.out.println(answer);
    }
}
