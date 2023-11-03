


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private final static List<Character> brackets = List.of('(', ')');
    private final static Set<String> results = new HashSet<>();
    private int max;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        results.clear();
        max = n * 2;
        generateParenthesisMy(0, 0, new char[max]);
        return new ArrayList<>(results);
    }

    private void generateParenthesisMy(int step, int openBracketQuantity, char[] result) {
        if (step == max) {
            if (openBracketQuantity == 0) {
                results.add(new String(result));
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (step == 0 && i == 1) {
                continue;
            }
            if (openBracketQuantity == 0 && i == 1) {
                continue;
            }
            char ch = brackets.get(i);
            result[step] = ch;
            generateParenthesisMy(step + 1, i == 0 ? openBracketQuantity + 1 : openBracketQuantity - 1, result);
            //    result.deleteCharAt(result.length() - 1);
        }
    }

    private boolean isLastSymbolClosedBrecket(StringBuilder result) {
        return result.charAt(result.length() - 1) == ')';
    }
}