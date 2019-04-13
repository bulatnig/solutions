class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int previous = 0;
        for (char c : s.toCharArray()) {
            int val = symbolValue(c);
            if (previous != 0 && previous < val) {
                val -= previous * 2;
                previous = 0;
            } else {
                previous = val;
            }
            result += val;
        }
        return result;
    }

    private int symbolValue(char symbol) {
        switch (symbol) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                throw new IllegalArgumentException("Unknown symbol passed: " + symbol);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("I"));
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
        System.out.println(new Solution().romanToInt("MMMCMXCIX"));
        System.out.println(new Solution().romanToInt("MMMCDXLIV"));
    }

}