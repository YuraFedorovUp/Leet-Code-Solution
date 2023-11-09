class Solution {
    private static final int MODULO = 1_000_000_007;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();

    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(countHomogenous("abbcccaa"));
    }

      public int countHomogenous(String s) {
        int left = 0;
        int right = -1;
        int result = 0;
        while (++right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                left = right;
            }
            result += right - left + 1;
            result %= MODULO;
        }
        return result;
    }
}