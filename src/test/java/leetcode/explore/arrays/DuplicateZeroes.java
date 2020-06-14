package leetcode.explore.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DuplicateZeroes {
    public void duplicateZeros1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (int k = arr.length - 2; k > i; k--) {
                    arr[k + 1] = arr[k];
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        int[] orig = new int[arr.length];
        System.arraycopy(arr, 0, orig, 0, arr.length);
        int origIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = orig[origIdx];
            if (orig[origIdx] == 0) {
                if (i < arr.length - 1) {
                    arr[i + 1] = 0;
                }
                i++;
            }
            origIdx++;
        }
    }

    public void duplicateZeros(int[] arr) {
        int zeroCount = 0;
        int idx = 0;
        for (; idx + zeroCount < arr.length; idx++) {
            if (arr[idx] == 0) {
                zeroCount++;
            }
        }
        int len = arr.length;
        if (idx + zeroCount > len) {
            arr[len - 1] = 0;
            len--;
            zeroCount--;
        }
        for (int srcPos = len - 1 - zeroCount, dstPos = len - 1; srcPos != dstPos; srcPos--, dstPos--) {
            if (arr[srcPos] == 0) {
                arr[dstPos] = 0;
                dstPos--;
            }
            arr[dstPos] = arr[srcPos];
        }
    }

    @Test
    public void test() {
        check(new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 0, 0, 2});
        check(new int[]{0, 0, 1, 2, 0}, new int[]{0, 1, 2, 0, 0});
        check(new int[]{1, 0, 0, 2, 0, 0, 3, 0, 0}, new int[]{1, 0, 2, 0, 3, 0, 4, 0, 5});
        check(new int[]{1, 0, 0, 2, 3, 0, 0, 4}, new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        check(new int[]{1, 2, 3}, new int[]{1, 2, 3});
        check(new int[]{0, 0}, new int[]{0, 2});
        check(new int[]{0, 0}, new int[]{0, 0});
        check(new int[]{0}, new int[]{0});
        check(new int[]{0, 0, 0}, new int[]{0, 0, 0});
        check(new int[]{8, 4, 5, 0, 0, 0, 0, 0}, new int[]{8, 4, 5, 0, 0, 0, 0, 7});
    }

    private void check(int[] expected, int[] input) {
        duplicateZeros(input);
        assertArrayEquals(expected, input);
    }
}
