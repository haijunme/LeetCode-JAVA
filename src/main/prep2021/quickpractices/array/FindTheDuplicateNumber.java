package main.prep2021.quickpractices.array;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // left and right represent actual numbers in range [1, n] inclusive
        int left = 1;
        int right = nums.length;

        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;

            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            // for missing numbers, count = 0
            if (count <= mid) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        // return the value of the duplicated number, not the index
        return answer;
    }
}
