import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        int negativeCase = A[0] * A[1] * A[A.length - 1];
        int positiveCase = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        return negativeCase > positiveCase ? negativeCase : positiveCase;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-3, 1, 2, -2, 5, 6}));
        System.out.println(new Solution().solution(new int[]{-1,-2,-3,5,4}));
    }
}