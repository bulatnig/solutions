package codility.lesson_4_counting_elements;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MissingInteger {
    public int solution(int[] A) {
        Arrays.sort(A);
        int expected = 1;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val < expected) {
                continue;
            } else if (val > expected) {
                return expected;
            } else {
                expected++;
            }
        }
        return expected;
    }

    @Test
    public void test() {
        assertEquals(5, solution(new int[]{1, 3, 6, 4, 1, 2}));
        assertEquals(4, solution(new int[]{1, 2, 3}));
        assertEquals(1, solution(new int[]{-1, -3}));
    }
}
