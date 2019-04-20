package codility.lesson_02_arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OddOccurrencesInArray {
    public int solution1(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i = i + 2) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }

    /**
     * Shows worse performance than solution1
     */
    public int solution2(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Map<Integer, Boolean> map = new HashMap<>(A.length);
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (map.remove(val) != null) {
                sum -= val;
            } else {
                map.put(val, Boolean.TRUE);
                sum += val;
            }
        }
        return (int) sum;
    }

    @Test
    public void test() {
        assertEquals(7, solution1(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

}
