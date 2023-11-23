package main.prep2021.quickpractices.slidingwindow;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int answer = 0, product = 1, left = 0;
        for (int right = 0; right < nums.length; right ++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            answer += right - left + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        var solution = new SubarrayProductLessThanK();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{3, 3}, 1));
    }
}
