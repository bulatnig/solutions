package codility.lesson_03_time_complexity;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PermMissingElem {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != (i + 1)) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

    @Test
    public void test() {
        assertEquals(4, solution(new int[]{2, 3, 1, 5}));
    }
}