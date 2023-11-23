package main.prep2021.quickpractices;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int insert = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[insert++] = nums[i];
            }
        }
        for (int i = insert; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] array = new int[]{0,1,0,3,12};
        moveZeroes.moveZeroes(array);
        System.out.println(Arrays.toString(array));
    }
}
