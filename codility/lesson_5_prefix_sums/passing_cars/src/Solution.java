class Solution {
    public int solution(int[] A) {
        int[] eastTotals = new int[A.length];
        int eastSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                eastSum++;
            }
            eastTotals[i] = eastSum;
        }

        int passingSum = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1) {
                passingSum += eastTotals[i];
                if (passingSum > 1_000_000_000) {
                    return -1;
                }
            }
        }

        return passingSum;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{0, 1, 0, 1, 1}));
//        System.out.println(new Solution().solution(new int[]{1}));
//        System.out.println(new Solution().solution(new int[]{0}));
//        System.out.println(new Solution().solution(new int[]{1, 0}));
//        System.out.println(new Solution().solution(new int[]{0, 1}));
        System.out.println(new Solution().solution(new int[]{0, 0, 0, 1, 1}));
    }

}
