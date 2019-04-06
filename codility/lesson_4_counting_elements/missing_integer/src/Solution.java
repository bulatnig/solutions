import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int expected = 1;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val < expected) {
                continue;
            } else if (val > expected) {
                return expected;
            } else {
                expected++;
            }
        }
        return expected;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(new Solution().solution(new int[]{1, 2, 3}));
        System.out.println(new Solution().solution(new int[]{-1, -3}));
    }
}