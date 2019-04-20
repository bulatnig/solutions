package cracking._01_arrays;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class CheckPermutation {

    public boolean isPermutation1(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        for (int i = 0; i < aChars.length; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPermutation2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] charCounters = new int[256];
        for (char i : a.toCharArray()) {
            charCounters[i] = charCounters[i] + 1;
        }
        for (char i : b.toCharArray()) {
            charCounters[i]--;
            if (charCounters[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPermutation(String a, String b) {
        return isPermutation2(a, b);
    }

    @Test
    public void test() {
        assertTrue(isPermutation("abcd", "cbad"));
        assertFalse(isPermutation("abcd", "cbae"));
        assertFalse(isPermutation("abcd", "cbaD"));
        assertFalse(isPermutation("a", "b"));
        assertTrue(isPermutation("a", "a"));
    }

}
