class Solution {
    public int[] solution(int[] A, int K) {
        if (A.length == 0) {
            return A;
        }
        int k = K >= A.length ? K % A.length : K;
        if (k == 0) {
            return A;
        }
        int[] result = new int[A.length];
        for (int i = 0; i < k; i++) {
            result[i] = A[A.length - k + i];
        }
        for (int i = 0; i < A.length - k; i++) {
            result[i + k] = A[i];
        }
        return result;
    }
}