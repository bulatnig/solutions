package leetcode.explore.arrays;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] != 1) {
            missingNumbers.add(1);
        }
        int expected = 2;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] != nums[i - 1] && nums[i] != expected) {
                    missingNumbers.add(expected);
                }
                expected++;
            }
        }
        return missingNumbers;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] counters = new int[nums.length];
        for (int num: nums) {
            counters[num - 1]++;
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] == 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    @Test
    public void test() {
        check(Arrays.asList(5, 6), new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

    private void check(List<Integer> expected, int[] input) {
        List<Integer> actual = findDisappearedNumbers(input);
        assertThat(actual, is(expected));
    }
}
