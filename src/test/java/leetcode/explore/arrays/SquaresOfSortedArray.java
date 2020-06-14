package leetcode.explore.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SquaresOfSortedArray {
    public int[] sortedSquares1(int[] A) {
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int rightIdx = A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                rightIdx = i;
                break;
            }
        }
        int leftIdx = rightIdx - 1;
        int resultIdx = 0;
        while (leftIdx > -1 || rightIdx < A.length) {
            int leftSquare = Integer.MAX_VALUE;
            int rightSquare = Integer.MAX_VALUE;
            if (leftIdx > -1) {
                leftSquare = A[leftIdx] * A[leftIdx];
            }
            if (rightIdx < A.length) {
                rightSquare = A[rightIdx] * A[rightIdx];
            }
            if (leftSquare > rightSquare) {
                result[resultIdx] = rightSquare;
                rightIdx++;
            } else {
                result[resultIdx] = leftSquare;
                leftIdx--;
            }
            resultIdx++;
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}
