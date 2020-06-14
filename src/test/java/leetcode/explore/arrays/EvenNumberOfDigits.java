package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = 0;
            do {
                num = num / 10;
                digits++;
            } while (num > 0);
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(0, findNumbers(new int[]{}));
        assertEquals(1, findNumbers(new int[]{555,901,482,1771}));
        assertEquals(2, findNumbers(new int[]{12,345,2,6,7896}));
        assertEquals(3, findNumbers(new int[]{1, 22, 333, 4444, 55555, 666666}));
    }
}
