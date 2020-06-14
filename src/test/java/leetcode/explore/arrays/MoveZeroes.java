package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < nums.length; readIdx++) {
            if (nums[readIdx] != 0) {
                nums[writeIdx] = nums[readIdx];
                writeIdx++;
            } else {
                zeroCount++;
            }
        }
        for (int i = nums.length - zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    public void test() {
        check(new int[]{1, 3, 12, 0, 0}, new int[]{0, 1, 0, 3, 12});
    }

    private void check(int[] expectedValues, int[] nums) {
        moveZeroes(nums);
        assertArrayEquals(expectedValues, nums);
    }
}
