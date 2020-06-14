package leetcode.explore.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NDoubleExists {
    public boolean checkIfExist1(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length) {
            if (i == j) {
                j++;
                continue;
            }
            if (arr[i] < 0 || arr[j] < 0) {
                int d = 2 * arr[j];
                if (d == arr[i]) {
                    return true;
                } else if (d > arr[i]) {
                    i++;
                } else {
                    j++;
                }
            } else {
                int d = 2 * arr[i];
                if (d == arr[j]) {
                    return true;
                } else if (d < arr[j]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i] * 2)) {
                return true;
            }
            if (arr[i] % 2 == 0 && map.containsKey(arr[i] / 2)) {
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
    }

    @Test
    public void test() {
        assertFalse(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
        assertTrue(checkIfExist(new int[]{10, 2, 5, 3}));
        assertTrue(checkIfExist(new int[]{7, 1, 14, 11}));
        assertFalse(checkIfExist(new int[]{3, 1, 7, 11}));
        assertTrue(checkIfExist(new int[]{-10, 12, -20, -8, 15}));
    }
}
