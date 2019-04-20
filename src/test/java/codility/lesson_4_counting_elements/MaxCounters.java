package codility.lesson_4_counting_elements;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int stash = 0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            if (x > N) {
                if (maxCounter > 0) {
                    stash += maxCounter;
                    maxCounter = 0;
                    counters = new int[N];
                }
            } else {
                int pos = x - 1;
                int newVal = counters[pos] + 1;
                counters[pos] = newVal;
                if (newVal > maxCounter) {
                    maxCounter = newVal;
                }
            }
        }
        for (int i = 0; i < counters.length; i++) {
            counters[i] += stash;
        }
        return counters;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 2, 2, 4, 2}, solution(5, new int[]{3, 4, 4, 6, 1, 4, 4}));
        assertArrayEquals(new int[]{1, 1}, solution(2, new int[]{1, 2}));
    }
}
