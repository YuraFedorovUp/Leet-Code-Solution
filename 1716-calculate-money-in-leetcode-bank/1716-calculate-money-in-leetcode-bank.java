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
        System.out.println(totalMoney(1000) + " 10");
    }

    private void test1() {
        System.out.println(totalMoney(10) + "  37");
    }

    public int totalMoney(int n) {
        return getTotalMoney(0, n);
    }

    private int getTotalMoney(int numberOfWeek, int n) {
        if ((numberOfWeek + 1) * 7 >= n) {
            return getSum(numberOfWeek + 1, n - (numberOfWeek * 7));
        }
        int cur = getSum(numberOfWeek + 1, 7);
        return cur + getTotalMoney(numberOfWeek + 1, n);
    }

    private int getSum(int firstCount, int x) {
            return (2 * firstCount + x - 1)  * x/ 2;
    }
}