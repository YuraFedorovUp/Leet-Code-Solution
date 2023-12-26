class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MODULO = (int) 1e9 + 7;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        // Loop through each dice
        for (int diceCount = 1; diceCount <= n; ++diceCount) {
            int[] tempDp = new int[target + 1];
            for (int currentSum = 1; currentSum <= Math.min(target, diceCount * k); ++currentSum) {
                for (int faceValue = 1; faceValue <= Math.min(currentSum, k); ++faceValue) {
                    tempDp[currentSum] = (tempDp[currentSum] + dp[currentSum - faceValue]) % MODULO;
                }
            }
            dp = tempDp;
        }
        return dp[target];
    }
}