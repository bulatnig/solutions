class Solution {
    public int solution(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }
        int minDiff = Math.abs(leftSum - rightSum);
        int item;
        int diff;
        for (int i = 1; i < A.length - 1; i++) {
            item = A[i];
            leftSum += item;
            rightSum -= item;
            diff = Math.abs(leftSum - rightSum);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int result = new Solution().solution(new int[]{5, 6, 2, 4, 1});
//        int result = new Solution().solution(new int[]{-1000, 1000});
//        int result = new Solution().solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(result);
    }
}