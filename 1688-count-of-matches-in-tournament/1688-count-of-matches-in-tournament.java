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
        System.out.println(numberOfMatches(7));
    }

    private void test1() {
        System.out.println(numberOfMatches(3));
    }

    public int numberOfMatches(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int playQuantity = n / 2;
        int nextMembersQuantity = n % 2 == 0 ? playQuantity : playQuantity + 1;
        return playQuantity + numberOfMatches(nextMembersQuantity);
    }
}