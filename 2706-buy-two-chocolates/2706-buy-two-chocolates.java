import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(buyChoco(new int[]{1, 1, 3}, 3));
    }


    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int change = money - prices[0] - prices[1];
        return change < 0 ? money : change;
    }
}