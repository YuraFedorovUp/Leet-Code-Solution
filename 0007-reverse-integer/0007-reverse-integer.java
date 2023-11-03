


public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(reverse(1534236469));
    }

    public int reverse(int x) {
        boolean isNegativ = x < 0;
        if (isNegativ) {
            x = -x;
        }
        String s = String.valueOf(x);
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isMoreThenEdge(result)) {
                return 0;
            }
            result = result * 10 + Integer.valueOf("" + s.charAt(i));
            if (result < 0 ) {
                return 0;
            }
        }
        return isNegativ ? -result : result;
    }

    private boolean isMoreThenEdge(int result) {
        return result > 9_00_000_000;
    }
}