package leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 32-bit signed integer
 * Corner cases: overflow -> return 0
 */
public class N0007_Reverse_Integer {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int left = x;
        int result = 0;
        while (left != 0) {
            int digit = Math.abs(left % 10);
            if ((result * 10 + digit) / 10 != result) {
                return 0;
            }
            result = result * 10 + digit;
            left = left / 10;
        }
        return x > 0 ? result : -1 * result;
    }

    @Test
    public void test() {
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
        assertEquals(0, reverse(1534236469));
    }
}
