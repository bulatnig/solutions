package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1ReadPos = m - 1;
        int nums2ReadPos = n - 1;
        for (int writePos = m + n - 1; writePos > -1; writePos--) {
            if (nums2ReadPos < 0 || (nums1ReadPos > -1 && nums1[nums1ReadPos] > nums2[nums2ReadPos])) {
                nums1[writePos] = nums1[nums1ReadPos];
                nums1ReadPos--;
            } else {
                nums1[writePos] = nums2[nums2ReadPos];
                nums2ReadPos--;
            }
        }
    }

    @Test
    public void test() {
        check(new int[]{1, 2, 2, 3, 5, 6}, new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        check(new int[]{1}, new int[]{0}, 0, new int[]{1}, 1);
        check(new int[]{1, 2}, new int[]{2, 0}, 1, new int[]{1}, 1);
    }

    private void check(int[] expected, int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}
