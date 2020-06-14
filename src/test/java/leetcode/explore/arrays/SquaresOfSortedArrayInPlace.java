package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

// This time, you must solve it in O(N) time and O(1) space. No using built-in sort, and no creating a new array.
public class SquaresOfSortedArrayInPlace {

    public int[] sortedSquares(int[] A) {
        // find first positive index
        int firstPositiveIdx = A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                firstPositiveIdx = i;
                break;
            }
        }
        // square all elements of the array
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        // now we have two parts in the array
        // first part on the left till A[rightIdx - 1] is sorted in decreasing order
        // second part on the right from A[rightIdx] is sorted in increasing order
        // sort first part in increasing order too by swapping elements
        for (int i = 0; i < firstPositiveIdx / 2; i++) {
            int tmp = A[i];
            A[i] = A[firstPositiveIdx - 1 - i];
            A[firstPositiveIdx - 1 - i] = tmp;
        }
        if (firstPositiveIdx == A.length) {
            return A; // array already fully sorted
        }
        // merge two parts
        int movedIdx = -1; // first index of the value moved from the left to the right
        for (int i = 0, j = firstPositiveIdx; i < j && i < A.length; i++) {
            if (i == movedIdx) {
                movedIdx++;
            }
            if (movedIdx == j) {
                movedIdx = -1;
            }
            if (j < A.length && A[j] < A[i] && (movedIdx < 0 || A[j] < A[movedIdx])) {
                swap(A, i, j);
                if (movedIdx < 0) {
                    movedIdx = j;
                }
                j++;
            } else if (movedIdx > 0 && A[movedIdx] < A[i]) {
                swap(A, i, movedIdx);
                for (int k = movedIdx + 1; k < j; k ++) {
                    if (A[k-1] > A[k]) {
                        swap(A, k, k - 1);
                    }
                }
            }
        }
        return A;
    }

    private void swap(int[] A, int idx1, int idx2) {
        int tmp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = tmp;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1,1,1,4,9,16,25,49,100}, sortedSquares(new int[]{-10,-5,-4,-3,-2,-1,0,1,1,7}));
        assertArrayEquals(new int[]{1, 4, 9, 9}, sortedSquares(new int[]{-3,-3,-2,1}));
        assertArrayEquals(new int[]{0, 4, 9}, sortedSquares(new int[]{-3, 0, 2}));
        assertArrayEquals(new int[]{0, 1, 9, 16}, sortedSquares(new int[]{0,1,3,4}));
        assertArrayEquals(new int[]{1, 4, 9}, sortedSquares(new int[]{-3, -2, -1}));
        assertArrayEquals(new int[]{0, 1, 9}, sortedSquares(new int[]{-3, -1, 0}));
        assertArrayEquals(new int[]{0, 4}, sortedSquares(new int[]{-2, 0}));
        assertArrayEquals(new int[]{0, 4}, sortedSquares(new int[]{0, 2}));
        assertArrayEquals(new int[]{1, 4, 16, 25, 25}, sortedSquares(new int[]{-5, -4, 1, 2, 5}));
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}
