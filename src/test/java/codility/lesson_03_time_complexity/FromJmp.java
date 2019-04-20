package codility.lesson_03_time_complexity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FromJmp {
    public int solution(int X, int Y, int D) {
        if (X == Y) {
            return 0;
        }
        int distance = Y - X;
        int jumps = distance / D;
        if (distance % D > 0) {
            jumps++;
        }
        return jumps;
    }

    @Test
    public void test() {
        assertEquals(3, solution(10, 85, 30));
    }
}