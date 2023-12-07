public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        System.out.println(largestOddNumber("52") + " 5");
    }

    private void test1() {
        System.out.println(largestOddNumber("24804") + "  пустая строка");
    }

    public String largestOddNumber(String num) {
        final int lastIndex = getLastIndex(num);
        return lastIndex == -1 ? "" : num.substring(0, lastIndex+1);
    }

    private int getLastIndex(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int n = num.charAt(i) - '0';
            if (n % 2 == 1) {
                return i;
            }
        }
        return -1;
    }
}