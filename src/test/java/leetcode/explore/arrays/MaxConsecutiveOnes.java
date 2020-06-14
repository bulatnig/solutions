package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else if (count > 0) {
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        return count > maxCount ? count : maxCount;
    }

    @Test
    public void test() {
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 1, 0, 1, 1}));
        assertEquals(0, findMaxConsecutiveOnes(new int[]{}));
        assertEquals(0, findMaxConsecutiveOnes(new int[]{0,0,0,0}));
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1,1,1}));
    }
}
