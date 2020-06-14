package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReplaceElementsWithGreatestOnRight {
    public int[] replaceElements1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
            for (int j = i + 2; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    arr[i] = arr[j];
                }
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i > -1; i--) {
            if (arr[i] > max) {
                int val = arr[i];
                arr[i] = max;
                max = val;
            } else {
                arr[i] = max;
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{18, 6, 6, 6, 1, -1}, replaceElements(new int[]{17, 18, 5, 4, 6, 1}));
    }
}
