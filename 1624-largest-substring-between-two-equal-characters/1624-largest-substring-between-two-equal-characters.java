public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
    }

    private void test() {
        System.out.println("ожидаемый ответ 2; ф-" + maxLengthBetweenEqualCharacters("abca"));
    }

    private void test1() {
        System.out.println("ожидаемый ответ -1; ф-" + maxLengthBetweenEqualCharacters("cbzxy"));
    }

    private void test2() {
        System.out.println("ожидаемый ответ 0; ф-" + maxLengthBetweenEqualCharacters("aa"));
    }


    public int maxLengthBetweenEqualCharacters(String s) {
        final String revers = new StringBuilder(s).reverse().toString();
        final int length = s.length();
        int left = 0;
        int right = s.length() - 1;
        int result = -1;
        while (left < right) {
            int lDif = length - revers.indexOf(s.charAt(left)) - left - 2;
            int rDif = right - s.indexOf(s.charAt(right)) - 2;
            final int cur = Math.max(lDif, rDif);
            result = Math.max(cur, result);
            left++;
            right--;
        }
        return result;
    }
}
