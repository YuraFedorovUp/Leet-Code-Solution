class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
        test2();
    }

    private void test0() {
        final var result = reversePrefix("abcdefd", 'd');
        System.out.println("expected - " + "dcbaefd");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final var result = reversePrefix("xyxzxe", 'z');
        System.out.println("expected - " + "zxyxxe");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final var result = reversePrefix("abcdefd", 'p');
        System.out.println("expected - " + "abcdefd");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    public String reversePrefix(String word, char ch) {
        final var threshold = word.indexOf(ch);
        final var result = new StringBuilder();
        for (int i = threshold; i >= 0; i--) {
            result.append(word.charAt(i));
        }
        for (int i = threshold + 1; i < word.length(); i++) {
            result.append(word.charAt(i));
        }
        return result.toString();
    }
}