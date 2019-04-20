package codility.lesson_4_counting_elements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        Integer[] leaves = new Integer[X];
        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if (leaves[position - 1] == null) {
                leaves[position - 1] = i;
            }
        }
        Integer max = 0;
        for (int i = 0; i < leaves.length; i++) {
            Integer second = leaves[i];
            if (second == null) {
                return -1;
            }
            if (second > max) {
                max = second;
            }
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(6, solution(5, new int[]{1,3,1,4,2,3,5,4}));
        assertEquals(0, solution(1, new int[]{1}));
        assertEquals(4, solution(3, new int[]{1, 3, 1, 3, 2, 1, 3}));
    }
}
