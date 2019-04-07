import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            long p = A[i];
            long q = A[i + 1];
            long r = A[i + 2];
            if ((p + q) > r && (q + r) > p && (r + p) > q) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{}));
        System.out.println(new Solution().solution(new int[]{1}));
        System.out.println(new Solution().solution(new int[]{1,2}));
        System.out.println(new Solution().solution(new int[]{10, 2, 5, 1, 8, 20}));
        System.out.println(new Solution().solution(new int[]{10, 50, 5, 1}));
    }
}