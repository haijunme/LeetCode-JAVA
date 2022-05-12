package main.quickpractices.array;

public class MedianOfTwoSortedArrayVirtualIndex {
    private int M;
    private int N;

    // virtual index: 0, 1, 2,   3, 4, 5
    // actual index: 0, 1, 2    0, 1, 2
    //              [1, 3, 5], [2, 4, 6]
    //
    //   if I want to swap the 4th virtual element and the 2nd virtual element
    //   => swap nums2[0] (3 > M - 1, so we get the element from nums2, and the corresponding index is 3%M)
    // this should also work if the two arrays' sizes are different :)

    // What we really want to do?
    // just a quick sort, but based on virtual indexes! Then we return the virtual middle.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.M = nums1.length;
        this.N = nums2.length;
        return 0.0;
    }
}
