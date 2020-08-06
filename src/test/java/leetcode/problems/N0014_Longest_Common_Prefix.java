package leetcode.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class N0014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int k = 0; k < common.length(); k++) {
                if (k == str.length() || str.charAt(k) != common.charAt(k)) {
                    common = common.substring(0, k);
                    break;
                }
            }
            if (common.length() == 0) {
                break;
            }
        }
        return common;
    }

    @Test
    public void test() {
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
