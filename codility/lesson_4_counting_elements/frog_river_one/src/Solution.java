class Solution {
    public int solution(int X, int[] A) {
        Integer[] leaves = new Integer[X];
        for (int i = 0; i < A.length; i++) {
            int position = A[i];
            if (leaves[position - 1] == null) {
                leaves[position - 1] = i;
            }
        }
        Integer max = 0;
        for (int i = 0; i < leaves.length; i++) {
            Integer second = leaves[i];
            if (second == null) {
                return -1;
            }
            if (second > max) {
                max = second;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int result = new Solution().solution(5, new int[]{1,3,1,4,2,3,5,4});
//        int result = new Solution().solution(1, new int[]{1});
        int result = new Solution().solution(3, new int[]{1, 3, 1, 3, 2, 1, 3});
        System.out.println(result);
    }
}