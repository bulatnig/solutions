package codility.lesson_4_counting_elements;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PermCheck {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }
        return 1;
    }

    @Test
    public void test() {
        assertEquals(1, solution(new int[]{4,1,3,2}));
        assertEquals(0, solution(new int[]{4,1,3}));
        assertEquals(1, solution(new int[]{1}));
        assertEquals(0, solution(new int[]{2}));
    }
}