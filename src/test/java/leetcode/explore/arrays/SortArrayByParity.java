package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A.length < 2) {
            return A;
        }
        int tmp;
        for (int leftIdx = 0, rightIdx = A.length - 1; leftIdx < rightIdx; ) {
            if (A[leftIdx] % 2 == 0) {
                leftIdx++;
                continue;
            }
            if (A[rightIdx] % 2 != 0) {
                rightIdx--;
                continue;
            }
            tmp = A[leftIdx];
            A[leftIdx] = A[rightIdx];
            A[rightIdx] = tmp;
            leftIdx++;
            rightIdx--;
        }
        return A;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 2, 1}, sortArrayByParity(new int[]{0, 1, 2}));
        assertArrayEquals(new int[]{4,2,1,3}, sortArrayByParity(new int[]{3,1,2,4}));
    }
}
