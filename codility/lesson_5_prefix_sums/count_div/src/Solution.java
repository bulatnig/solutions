class Solution {
    public int solution(int A, int B, int K) {
        int result = B / K;
        if (A > 0) {
            result -= (A - 1) / K;
        } else {
            result += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(6, 11, 2));
        System.out.println(new Solution().solution(0, 1, 1));
        System.out.println(new Solution().solution(9, 10, 3));
        System.out.println(new Solution().solution(1, 2, 1));
    }
}