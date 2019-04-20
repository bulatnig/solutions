package cracking._01_arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class URLify {

    public char[] solution1(char[] input, int length) {
        if (input.length == length) {
            return input;
        }
        char[] result = new char[input.length];
        for (int i = 0, o = 0; i < length; i++, o++) {
            if (input[i] == ' ') {
                result[o] = '%';
                result[o + 1] = '2';
                result[o + 2] = '0';
                o += 2;
            } else {
                result[o] = input[i];
            }
        }
        return result;
    }

    public char[] solution2(char[] input, int length) {
        if (input.length == length) {
            return input;
        }
        for (int i = length - 1, o = input.length - 1; i != o; i--, o--) {
            if (input[i] == ' ') {
                input[o] = '0';
                input[o - 1] = '2';
                input[o - 2] = '%';
                o -= 2;
            } else {
                input[o] = input[i];
            }
        }
        return input;
    }

    @Test
    public void test() {
        assertEquals("Mr%20John%20Smith", new String(solution2(new char[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', 0, 0, 0, 0}, 13)));
        assertEquals("%20hi%20", new String(solution2(new char[]{' ', 'h', 'i', ' ', 0, 0, 0, 0}, 4)));
        assertEquals("you", new String(solution2(new char[]{'y', 'o', 'u'}, 3)));
        assertEquals("%20", new String(solution2(new char[]{' ', 0 ,0}, 1)));
    }
}
