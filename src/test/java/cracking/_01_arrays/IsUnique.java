package cracking._01_arrays;

import org.junit.Test;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class IsUnique {

    boolean unicode(String s) {
        BitSet occurence = new BitSet();
        return s.codePoints().allMatch(codePoint -> {
            if (occurence.get(codePoint)) {
                return false;
            }
            occurence.set(codePoint);
            return true;
        });
    }

    boolean eigthBitEncoding(String s) {
        boolean[] occurence = new boolean[256];
        for (char c : s.toCharArray()) {
            if (occurence[c]) {
                return false;
            }
            occurence[c] = true;
        }
        return true;
    }

    @Test
    public void testUnicode() {
        assertTrue(unicode("abcdПривет!\uD801\uDC00\uD801\uDC01"));
        assertFalse(unicode("abcdПривет!\uD801\uDC00\uD801\uDC00"));
    }

    @Test
    public void testEigthBitEncoding() {
        assertTrue(eigthBitEncoding("abcdEFDG"));
        assertFalse(eigthBitEncoding("abcdEFDaG"));
    }

}
