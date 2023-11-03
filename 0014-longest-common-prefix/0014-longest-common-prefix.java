


public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        String[] strs = new String[]{"flower", "", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        int ans = 0;
        int minIndex = getMinIndex(strs);
        for (int i = 0; i < minIndex; i++) {
            if (isPrefixContinios(i, strs)) {
                ans++;
            } else {
                return getStringbeforeIndex(i, strs[0]);
            }

        }
        return getStringbeforeIndex(minIndex, strs[0]);
    }

    private boolean isPrefixContinios(int i, String[] strs) {
        char currentChar = strs[0].charAt(i);
        for (String str : strs) {
            if (str.charAt(i) != currentChar) {
                return false;
            }
        }
        return true;
    }

    private String getStringbeforeIndex(int index, String str) {
        String result = "";
        for (int i = 0; i < index; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    private int getMinIndex(String[] strs) {
        int result = 1000;
        for (String str : strs) {
            if (result > str.length()) {
                result = str.length();
            }
        }
        return result;
    }
}