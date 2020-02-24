package stack.and.queque._20ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static boolean isValid(String s) {
        Map parentheses = new HashMap<Character,Character>();
        parentheses.put(')','(');
        parentheses.put(']','[');
        parentheses.put('}','{');
        char []chars = s.toCharArray();
        Stack stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                if (stack.isEmpty() || !stack.peek().equals(parentheses.get(chars[i]))) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}