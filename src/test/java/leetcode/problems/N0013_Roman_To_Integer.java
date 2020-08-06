package leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class N0013_Roman_To_Integer {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int prevValue = 0;
        for (int i = chars.length - 1; i > -1; i--) {
            char c = chars[i];
            int value;
            switch (c) {
                case 'I' -> value = 1;
                case 'V' -> value = 5;
                case 'X' -> value = 10;
                case 'L' -> value = 50;
                case 'C' -> value = 100;
                case 'D' -> value = 500;
                default -> value = 1000;
            }
            if (value < prevValue) {
                result -= value;
            } else {
                result += value;
            }
            prevValue = value;
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(3, romanToInt("III"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(9, romanToInt("IX"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
