package leetcode.explore.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RemoveElement {
    public int removeElement1(int[] nums, int val) {
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != val) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            }
        }
        return writeIdx;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    @Test
    public void test() {
        check(new int[]{2, 2}, 2, new int[]{2, 3, 3, 2}, 3);
        check(new int[]{2, 2}, 2, new int[]{3, 2, 2, 3}, 3);
        check(new int[]{0, 1, 3, 0, 4}, 5, new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }

    private void check(int[] expectedValues, int expectedLength, int[] nums, int val) {
        int actualLength = removeElement(nums, val);
        assertEquals(expectedLength, actualLength);
        Arrays.sort(expectedValues);
        int[] actual = new int[actualLength];
        System.arraycopy(nums, 0, actual, 0, actualLength);
        Arrays.sort(actual);
        assertArrayEquals(expectedValues, actual);
    }
}
