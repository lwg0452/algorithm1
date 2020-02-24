package stack.and.queque._20ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        char[] test = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (chars[i]) {
                case '(':
                    test[count] = ')';
                    count++;
                    break;
                case '[':
                    test[count] = ']';
                    count++;
                    break;
                case '{':
                    test[count] = '}';
                    count++;
                    break;
                default:
                    count--;
                    if (count < 0 || test[count] != chars[i]) {
                        return false;
                    }
            }
        }
        return count==0;
    }
}
