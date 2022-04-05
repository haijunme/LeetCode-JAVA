package main.quickpractices;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length-1;
        while (left < right) {
            maxArea = Math.max(maxArea, calculateArea(height, left, right));
            if (height[left] <= height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return maxArea;
    }

    private int calculateArea(int[] height, int left, int right) {
        return Math.min(height[left], height[right]) * (right - left);
    }

    public static void main(String[] args) {
        var solution = new ContainerWithMostWater();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
