package codility.lesson_03_time_complexity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }
        int minDiff = Math.abs(leftSum - rightSum);
        int item;
        int diff;
        for (int i = 1; i < A.length - 1; i++) {
            item = A[i];
            leftSum += item;
            rightSum -= item;
            diff = Math.abs(leftSum - rightSum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    @Test
    public void test() {
        assertEquals(1, solution(new int[]{3, 1, 2, 4, 3}));
        assertEquals(4, solution(new int[]{5, 6, 2, 4, 1}));
        assertEquals(2000, solution(new int[]{-1000, 1000}));
    }
}