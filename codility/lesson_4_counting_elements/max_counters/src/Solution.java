class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounter = 0;
        int stash = 0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            if (x > N) {
                if (maxCounter > 0) {
                    stash += maxCounter;
                    maxCounter = 0;
                    counters = new int[N];
                }
            } else {
                int pos = x - 1;
                int newVal = counters[pos] + 1;
                counters[pos] = newVal;
                if (newVal > maxCounter) {
                    maxCounter = newVal;
                }
            }
        }
        for (int i = 0; i < counters.length; i++) {
            counters[i] += stash;
        }
        return counters;
    }

    public static void main(String[] args) {
        int[] result = new Solution().solution(5, new int[] {3,4,4,6,1,4,4});
//        int[] result = new Solution().solution(2, new int[] {1, 2});
        for (int i : result) {
            System.out.print(i);
            System.out.print(',');
        }
    }
}