package cracking._01_arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.BitSet;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PalindromePermutation {

    public boolean solution1(String input) {
        char[] chars = input.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(chars); // gives us N*logN performance at max
        boolean oneFound = false;
        int i = 0;
        do {
            if (i < chars.length - 1) {
                if (chars[i] == chars[i + 1]) {
                    i++;
                } else if (oneFound) {
                    return false;
                } else {
                    oneFound = true;
                }
            } else if (oneFound) {
                return false;
            } else {
                break;
            }
            i++;
        } while (i < chars.length);
        return true;
    }

    public boolean solution2(String input) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        BitSet bitSet = new BitSet(z -a);
        for (char c : input.toCharArray()) {
            int val = Character.getNumericValue(c);
            if (val < 0) {
                continue;
            }
            int idx = val - a;
            bitSet.set(idx, !bitSet.get(idx));
        }
        return bitSet.cardinality() < 2;
    }

    public boolean solution(String input) {
        return solution2(input);
    }

    @Test
    public void test() {
        assertTrue(solution("Tact Coa"));
        assertTrue(solution("Tacto Coa"));
        assertFalse(solution("Tacts Coa"));
        assertFalse(solution("Tactt Coa"));
    }

}
