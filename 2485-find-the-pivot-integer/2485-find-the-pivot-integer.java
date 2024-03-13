public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        int ans = pivotInteger(2);
        System.out.println(ans);
    }

    public int pivotInteger(int n) {
        var left = 0;
        var right = (n + 1) * n / 2;
        for (int i = 1; i <= n; i++) {
            left += i;
            if (left == right) {
                return i;
            }
            right -= i;
        }
        return -1;
    }
}