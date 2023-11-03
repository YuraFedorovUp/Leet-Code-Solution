
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final Map<String, List<Character>> digitalToLetters;

    static {
        digitalToLetters = new HashMap<>();
        digitalToLetters.put("2", List.of('a', 'b', 'c'));
        digitalToLetters.put("3", List.of('d', 'e', 'f'));
        digitalToLetters.put("4", List.of('g', 'h', 'i'));
        digitalToLetters.put("5", List.of('j', 'k', 'l'));
        digitalToLetters.put("6", List.of('m', 'n', 'o'));
        digitalToLetters.put("7", List.of('p', 'q', 'r', 's'));
        digitalToLetters.put("8", List.of('t', 'u', 'v'));
        digitalToLetters.put("9", List.of('w', 'x', 'y', 'z'));
    }

    private List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        extract(0, digits, "");
        return ans;
    }

    private void extract(int step, String digits, String result) {
        if (step == digits.length()) {
            if(!result.isEmpty()) {
                ans.add(result);
            }
            return;
        }
        List<Character> characters = digitalToLetters.get("" + digits.charAt(step));
        for (char ch : characters) {
            String curResult = result + ch;
            extract(step + 1, digits, curResult);
        }
    }
}