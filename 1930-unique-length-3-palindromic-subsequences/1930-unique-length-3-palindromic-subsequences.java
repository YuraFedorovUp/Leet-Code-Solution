
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(countPalindromicSubsequence("abba"));
    }

    public int countPalindromicSubsequence(String s) {
        int result = 0;
        final Set<Character> letters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            letters.add(s.charAt(i));
        }
        for (char letter : letters) {
            int left = -1;
            int right = -1;
            final Set<Character> intermediaResults = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == letter) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }
            for (int i = left + 1; i < right; i++) {
                intermediaResults.add(s.charAt(i));
            }
            result += intermediaResults.size();
        }
        return result;
    }
}