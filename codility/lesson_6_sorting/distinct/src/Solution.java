import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int distinct = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i -1]) {
                distinct++;
            }
        }
        return distinct;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2,1,1,2,3,3}));
        System.out.println(new Solution().solution(new int[]{1,1 ,1, 1}));
        System.out.println(new Solution().solution(new int[]{4,3,2,1}));
        System.out.println(new Solution().solution(new int[]{}));
        System.out.println(new Solution().solution(new int[]{1}));
    }
}