public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int nums0[] = new int[]{7, 1, 0};
        System.out.println(maxProfit(nums0));
    }

    public int maxProfit(int[] prices) {
        int minCostForBying = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price - minCostForBying > 0) {
                profit = Math.max(profit, price - minCostForBying);
            }
            if (price < minCostForBying) {
                minCostForBying = price;
            }
        }
        return profit;
    }
}