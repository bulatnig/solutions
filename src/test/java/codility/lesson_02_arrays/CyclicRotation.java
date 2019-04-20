package codility.lesson_02_arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }
        int k = K % A.length;
        if (k == 0) {
            return A;
        }
        int[] result = new int[A.length];
        for (int i = 0; i < k; i++) {
            result[i] = A[A.length - k + i];
        }
        for (int i = 0; i < A.length - k; i++) {
            result[i + k] = A[i];
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{9, 7, 6, 3, 8}, solution(new int[]{3, 8, 9, 7, 6}, 3));
        assertArrayEquals(new int[]{0, 0, 0}, solution(new int[]{0, 0, 0}, 1));
        assertArrayEquals(new int[]{1, 2, 3, 4}, solution(new int[]{1, 2, 3, 4}, 4));
    }
}