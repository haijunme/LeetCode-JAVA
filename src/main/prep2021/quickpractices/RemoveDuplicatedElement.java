package main.prep2021.quickpractices;

public class RemoveDuplicatedElement {

    public static int removeDuplicates(int[] nums) {
        int firstDuplicateIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[firstDuplicateIndex] = nums[i];
                firstDuplicateIndex ++;
            }
        }
        return firstDuplicateIndex;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,2,3,4,6}));

        System.out.println(removeDuplicates(new int[]{1,1,1,4,6}));
    }
}
