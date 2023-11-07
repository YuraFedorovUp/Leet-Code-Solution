public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("01101110", 2, 3));
        System.out.println(canReach(
              "010" ,
                1,
                99999));
    }

    public boolean canReach(String s, int minJ, int maxJ) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJ && dp[i - minJ])
                pre++;
            if (i > maxJ && dp[i - maxJ - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}