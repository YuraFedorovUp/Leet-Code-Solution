public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(isReachableAtTime(3, 1, 7, 3, 3));
        System.out.println(isReachableAtTime(2,4,7,6,6));
        System.out.println(isReachableAtTime(1, 2, 1, 2, 1));
    }

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        final int distMax = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if (distMax == 0) {
            return t != 1;
        }
        return distMax <= t;
    }
}