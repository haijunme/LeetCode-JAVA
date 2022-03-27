public class BinarySearch {
    private int binarySearch(int[] nums, int target, int start, int end) {
        int midIndex = (start + end)/2;
        if (nums[midIndex] == target) {
            return midIndex;
        }
        if (start >= end) {
            return -1;
        }
        if (nums[midIndex] < target) {
            return binarySearch(nums, target, midIndex+1, end);
        }
        return binarySearch(nums, target, start, midIndex-1);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 1));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 2));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 3));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 4));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 5));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, -1));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 6));
        System.out.println("-------");
        System.out.println(binarySearch.search(new int[]{1,2,3,4}, 1));
        System.out.println(binarySearch.search(new int[]{1,2,3,4}, 2));
        System.out.println(binarySearch.search(new int[]{1,2,3,4}, 3));
        System.out.println(binarySearch.search(new int[]{1,2,3,4}, 4));
        System.out.println(binarySearch.search(new int[]{1,2,3,4,5}, 5));
        System.out.println("-------");
        System.out.println(binarySearch.search(new int[]{}, 3));
    }
}
