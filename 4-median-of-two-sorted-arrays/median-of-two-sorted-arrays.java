class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        while (low <= high) {

            // Partition of nums1
            int partition1 = (low + high) / 2;

            // Partition of nums2
            int partition2 = (m + n + 1) / 2 - partition1;

            // Elements immediately to the left/right of partitions
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition found
            if (left1 <= right2 && left2 <= right1) {

                // Total number of elements is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2)
                            + Math.min(right1, right2)) / 2.0;
                }

                // Total number of elements is odd
                return Math.max(left1, left2);
            }

            // We have taken too many elements from nums1
            else if (left1 > right2) {
                high = partition1 - 1;
            }

            // We need to take more elements from nums1
            else {
                low = partition1 + 1;
            }
        }

        return 0.0; // Should never reach here
    }
}