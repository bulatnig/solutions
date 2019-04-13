class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int input = x;
        int output = 0;
        while (input != 0) {
            int num = input % 10;
            input = input / 10;
            if (output > Integer.MAX_VALUE / 10 || (output == Integer.MAX_VALUE / 10 && num > 7)) {
                return false;
            }
            output = output * 10 + num;
        }
        return output == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(10));
        System.out.println(new Solution().isPalindrome(Integer.MAX_VALUE));
        System.out.println(new Solution().isPalindrome(2147447412));
        System.out.println(new Solution().isPalindrome(2147447999));
    }
}