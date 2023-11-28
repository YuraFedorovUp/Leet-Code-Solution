public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
        test2();
    }

    private void test() {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    private void test1() {
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    private void test2() {
        System.out.println(minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818));
    }

    public int minEatingSpeed(int[] piles, int h) {
        long maxSpeed = getMaxSpeed(piles);
        return (int) binarySearch(piles, 1, maxSpeed, h);
    }

    private long binarySearch(int[] piles, long minSpeed, long maxSpeed, int days) {
        long left = minSpeed;
        long right = maxSpeed;
        long result = Integer.MAX_VALUE;
        while (left <= right) {
            if (left == right && isApproachCapacity(piles, days, left)) {
                result = Math.min(result, left);
            }
            long mid = left + (right - left) / 2;
            final boolean isApproachCapacity = isApproachCapacity(piles, days, mid);
            if (isApproachCapacity) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private long getMaxSpeed(int[] weights) {
        long sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }


    private boolean isApproachCapacity(int[] piles, int h, long capacity) {
        long step = 0;
        for (int pile : piles) {
            int curPile = pile;
//            while (curPile > 0) {
//                curPile -= capacity;
//                step++;
//            }
            step += pile / capacity;
            if (pile % capacity != 0) {
                step++;
            }
        }
        return step <= h;
    }
}