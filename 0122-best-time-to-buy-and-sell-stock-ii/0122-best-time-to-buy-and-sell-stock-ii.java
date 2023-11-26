public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int nums0[] = new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(nums0));
    }

    public int maxProfit(int[] prices) {
        final int length = prices.length;
        boolean isStockPresent = false;
        int priceBying = -1;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (isStockPresent) {
                profit += prices[i] - priceBying;
                if (i != length - 1 && prices[i + 1] > prices[i]) {
                    priceBying = prices[i];
                    isStockPresent = true;
                } else {
                    isStockPresent = false;
                }
            } else {
                if (i != length - 1 && prices[i + 1] > prices[i]) {
                    priceBying = prices[i];
                    isStockPresent = true;
                }
            }
        }
        return profit;
    }
}