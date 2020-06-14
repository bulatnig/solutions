package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3 || A[1] <= A[0]) {
            return false;
        }
        boolean decreasing = false;
        for (int i = 2; i < A.length; i++) {
            if (decreasing && A[i] >= A[i - 1]) {
                return false;
            }
            if (!decreasing) {
                if (A[i] == A[i -1]) {
                    return false;
                } else if (A[i] < A[i -1]) {
                    decreasing = true;
                }
            }
        }
        return decreasing;
    }

    @Test
    public void test() {
        assertFalse(validMountainArray(new int[]{2,1}));
        assertFalse(validMountainArray(new int[]{3,5,5}));
        assertTrue(validMountainArray(new int[]{0,3,2,1}));
    }
}
