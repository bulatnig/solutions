class Solution {
    public int solution(int N) {
        int n = removeRightEndZeroes(N);
        int maxGap = 0;
        int gap = 0;
        while (n > 1) {
            if (rightmostBitIsZero(n)) {
                gap++;
            } else {
                if (gap > maxGap) {
                    maxGap = gap;
                }
                gap = 0;
            }
            n = rightShift(n);
        }
        if (gap > maxGap) {
            maxGap = gap;
        }
        return maxGap;
    }

    private int removeRightEndZeroes(int n) {
        while (rightmostBitIsZero(n)) {
            n = rightShift(n);
        }
        return n;
    }

    private boolean rightmostBitIsZero(int n) {
        return (n & 0b1) == 0;
    }

    private int rightShift(int n) {
        return n >>> 1;
    }

}
