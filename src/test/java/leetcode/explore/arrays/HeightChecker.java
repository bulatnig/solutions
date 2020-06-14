package leetcode.explore.arrays;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HeightChecker {
    public int heightChecker1(int[] heights) {
        if (heights.length == 1) {
            return 0;
        }
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int counter = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                counter++;
            }
        }
        return counter;
    }
    public int heightChecker(int[] heights) {
        if (heights.length == 1) {
            return 0;
        }
        int[] heightCounters = new int[100];
        for (int height : heights) {
            heightCounters[height - 1]++;
        }
        int position = 0;
        int moves = 0;
        for (int i = 0; i < heightCounters.length && position < 100; i++) {
            while (heightCounters[i] > 0) {
                if (heights[position] != i + 1) {
                    moves++;
                }
                heightCounters[i]--;
                position++;
            }
        }
        return moves;
    }

    @Test
    public void test() {
        assertEquals(3, heightChecker(new int[]{1,1,4,2,1,3}));
        assertEquals(5, heightChecker(new int[]{5,1,2,3,4}));
        assertEquals(0, heightChecker(new int[]{1,2,3,4,5}));
    }
}
