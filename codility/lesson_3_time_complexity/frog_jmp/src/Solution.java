class Solution {
    public int solution(int X, int Y, int D) {
        if (X == Y) {
            return 0;
        }
        int distance = Y - X;
        int jumps = distance / D;
        if (distance % D > 0) {
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        int result = new Solution().solution(10, 85, 30);
        System.out.println(result);
    }
}