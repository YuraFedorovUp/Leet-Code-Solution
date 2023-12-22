class Solution {
  public int maxScore(String s) {
        int right = getRight(s);
        int left = 0;
        int result = right;
        if (s.charAt(0)=='0'){
            left++;
            result++;
        }
        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                right--;
            } else {
                left++;
                result = Math.max(result, left + right);
            }
        }
        return result;
    }

    private int getRight(String s) {
        int right = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        return right;
    }
}