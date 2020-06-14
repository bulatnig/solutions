package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max1 = nums[0];
        int max2 = nums[0];
        int max3 = nums[0];
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num != max1) {
                if (max2 == max1 || num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num != max2 && (max3 == max1 || max3 == max2 || num > max3)) {
                    max3 = num;
                }
            }
        }
        if (max3 != max2) {
            return max3;
        } else {
            return max1;
        }
    }

    @Test
    public void test() {
        assertEquals(1, thirdMax(new int[]{3, 2, 1}));
        assertEquals(2, thirdMax(new int[]{1, 2}));
        assertEquals(1, thirdMax(new int[]{2, 2, 3, 1}));
    }
}
