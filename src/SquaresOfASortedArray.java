import java.util.Arrays;

public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i <= j) {
            int left = nums[i] * nums[i];
            int right = nums[j] * nums[j];
            if (left <= right) {
                result[k--] = right;
                j--;
            } else {
                result[k--] = left;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray squaresOfASortedArray = new SquaresOfASortedArray();
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{0, 1, 2, 3})));
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{-5, -4, -3, -2})));
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{-5, -4, -3, -2, 0})));
        System.out.println(Arrays.toString(squaresOfASortedArray.sortedSquares(new int[]{-2, -1, 3})));
    }
}
