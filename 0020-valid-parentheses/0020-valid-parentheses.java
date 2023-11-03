


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private static final Map<Character, Character> closeBracketToOpenBreacket;

    static {
        closeBracketToOpenBreacket = new HashMap<>();
        closeBracketToOpenBreacket.put('}', '{');
        closeBracketToOpenBreacket.put(')', '(');
        closeBracketToOpenBreacket.put(']', '[');
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(isValid("()[(]{)}"));
    }

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        stack.push('0');
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char previos = stack.peek();
            if (previos==closeBracketToOpenBreacket.getOrDefault(ch,'p') ) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size() == 1;
    }
}