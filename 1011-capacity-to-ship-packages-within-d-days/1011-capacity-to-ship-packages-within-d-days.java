public class Solution {
    private int maxWeight = 0;
    private int sumWeight = 0;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        fillMaxWeightSumWeight(weights);
        return binarySearch(weights, maxWeight, sumWeight, days);
    }

    private int binarySearch(int[] weights, int maxWeight, int sumWeight, int days) {
        int left = maxWeight;
        int right = sumWeight;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            if (left == right && isApproachCapacity(weights, days, left)) {
                result = Math.min(result, left);
            }
            int mid = left + (right - left) / 2;
            final boolean isApproachCapacity = isApproachCapacity(weights, days, mid);
            if (isApproachCapacity) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private void fillMaxWeightSumWeight(int[] weights) {
        maxWeight = 0;
        sumWeight = 0;
        for (int weight : weights) {
            sumWeight += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
    }


    private boolean isApproachCapacity(int[] weights, int days, int capacity) {
        int step = 0;
        int curSum = 0;
        for (int weight : weights) {
            if (curSum + weight > capacity) {
                step++;
                curSum = weight;
            } else {
                curSum += weight;
            }
        }
        return step + 1 <= days;
    }
}