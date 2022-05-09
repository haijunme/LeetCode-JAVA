package main.quickpractices.array;

import java.util.Arrays;

public class SortColors {
    private void swap(int[] nums, int i, int j) {
        int temporary = nums[i];
        nums[i] = nums[j];
        nums[j] = temporary;
    }

    public void sortColors(int[] nums) {
        // create an index tracker, O(1) space complexity
        int insertion = 0;

        // swap all 0 to the front of the array, O(n) time complexity
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, insertion++);
            }
        }

        // the input array is not consisted of 0 solely
        if (insertion < nums.length) {
            // swap all 1 to the middle of the array,  O(n) time complexity
            for (int i = insertion; i < nums.length; i++) {
                if (nums[i] == 1) {
                    swap(nums, i, insertion++);
                }
            }
        }
    }

    public static void main(String[] args) {
        var solution = new SortColors();
        int[] colors = new int[]{1,2,0,2,0,0,0,1};
        solution.sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }
}
