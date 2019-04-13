/**
 * https://leetcode.com/problems/reverse-integer/
 */
class Solution {
    public int reverse(int x) {
        if (Integer.MIN_VALUE == x) { // this is a special case for Math.abs()
            return 0;
        }
        if (Math.abs(x) < 10) {
            return x;
        }
        int sign = x >= 0 ? 1 : -1;
        String origString = Integer.toString(Math.abs(x));
        String reversedString = new StringBuilder(origString).reverse().toString();
        int reversed;
        try {
            reversed = Integer.parseInt(reversedString);
        } catch (NumberFormatException e) {
            return 0;
        }
        return sign * reversed;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(-1));
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(-2147483647));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(new Solution().reverse(-2147483412));
    }
}