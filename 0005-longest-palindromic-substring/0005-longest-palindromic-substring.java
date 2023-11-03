

public class Solution {
      public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int[] longestPalindromeIndexes = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int[] currenPalindromeIndexes = getLongestPalindromeIndexes(s, i, i);
            if (currenPalindromeIndexes[1] - currenPalindromeIndexes[0] > longestPalindromeIndexes[1] - longestPalindromeIndexes[0]) {
                longestPalindromeIndexes = currenPalindromeIndexes;
            }
            if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)){
                int[] evenCurrenPalindromeIndexes = getLongestPalindromeIndexes(s, i, i+1);
                if (evenCurrenPalindromeIndexes[1] - evenCurrenPalindromeIndexes[0] > longestPalindromeIndexes[1] - longestPalindromeIndexes[0]) {
                    longestPalindromeIndexes = evenCurrenPalindromeIndexes;
                }
            }
        }
        return s.substring(longestPalindromeIndexes[0], longestPalindromeIndexes[1]+1);
    }
    private int[] getLongestPalindromeIndexes(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new int[]{left + 1, right - 1};
    }
}
