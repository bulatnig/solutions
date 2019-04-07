/**
 * https://www.martinkysel.com/codility-minavgtwoslice-solution/
 */
class Solution {
    public int solution(int[] A) {
        double minValue = Integer.MAX_VALUE;
        int minPos = -1;
        for (int i = 0; i < A.length - 1; i++) {
            double average = (A[i] + A[i + 1]) / 2.0;
            if (average < minValue) {
                minValue = average;
                minPos = i;
            }
            if (i < (A.length - 2)) {
                average = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                if (average < minValue) {
                    minValue = average;
                    minPos = i;
                }
            }
        }
        return minPos;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
        System.out.println(new Solution().solution(new int[]{1, 1}));
        System.out.println(new Solution().solution(new int[]{100, 1, 1}));
        System.out.println(new Solution().solution(new int[]{1, 100, 100}));
    }
}