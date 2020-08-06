package leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class N0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int left = x;
        int reverse = 0;
        while (left != 0) {
            int digit = left % 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return false;
            }
            reverse = reverse * 10 + digit;
            left = left / 10;
        }
        return reverse == x;
    }

    @Test
    public void test() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertFalse(isPalindrome(10));
    }
}
