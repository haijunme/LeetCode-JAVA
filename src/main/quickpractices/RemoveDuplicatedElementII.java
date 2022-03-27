package main.quickpractices;

import java.util.Arrays;

public class RemoveDuplicatedElementII {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int firstDuplicateIndex = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[firstDuplicateIndex-2]) {
                nums[firstDuplicateIndex] = nums[i];
                firstDuplicateIndex ++;
            }
        }
        return firstDuplicateIndex;
    }

    public static void main(String[] args) {
//        int[] array1 = new int[]{1,2,3,4,6};
//        System.out.println(array1);
//        System.out.println(Arrays.toString(array1));


        //int[] array2 = new int[]{0,0,1,1,1,1,2,3,3};
        int[] array2 = new int[]{0,1,1,1,2};
        System.out.println(removeDuplicates(array2));
        System.out.println(Arrays.toString(array2));
    }
}
