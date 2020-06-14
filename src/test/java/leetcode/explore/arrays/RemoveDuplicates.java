package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int insertIdx = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[insertIdx] = nums[i];
                prev = nums[i];
                insertIdx++;
            }
        }
        return insertIdx;
    }

    @Test
    public void test() {
        check(new int[]{1, 2}, 2, new int[]{1, 1, 2});
        check(new int[]{0, 1, 2, 3, 4}, 5, new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    private void check(int[] expectedValues, int expectedLength, int[] nums) {
        int actualLength = removeDuplicates(nums);
        assertEquals(expectedLength, actualLength);
        for (int i = 0; i < expectedLength; i++) {
            assertEquals(expectedValues[i], nums[i]);
        }
    }
}
