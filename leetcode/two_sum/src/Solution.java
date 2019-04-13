import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> candidates = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            int pairItem = target - item;
            Integer pairPos = candidates.get(pairItem);
            if (pairPos == null) {
                candidates.put(item, i);
            } else {
                return new int[]{pairPos, i};
            }
        }
        throw new IllegalArgumentException("No pair found");
    }
}
