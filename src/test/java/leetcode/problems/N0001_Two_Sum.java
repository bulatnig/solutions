package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Only one match.
 * Numbers can be negative.
 */
public class N0001_Two_Sum {
    /**
     * Time: O(n*n)
     * Space: O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            int expected = target - nums[i];
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] == expected) {
                    return new int[] {i, k};
                }
            }
        }
        throw new IllegalArgumentException("At least one match expected");
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer firstIdx = map.get(target - nums[i]);
            if (firstIdx != null) {
                return new int[] {firstIdx, i};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("At least one match expected");
    }
}
