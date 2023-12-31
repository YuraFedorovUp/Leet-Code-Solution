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
        System.out.println(largestGoodInteger("6777133339"));
    }

    private void test1() {
        System.out.println(largestGoodInteger("6777133339"));
    }

    public String largestGoodInteger(String num) {
        char resultChar = 2;
        for (int i = 0; i < num.length() - 2; i++) {
            final char ch = num.charAt(i);
            if (ch < resultChar) {
                continue;
            }
            if (ch == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (resultChar < ch)
                    resultChar = ch;
            }
        }
        return resultChar == 2 ? "" : String.valueOf(resultChar + "" + resultChar + "" + resultChar);
    }
}