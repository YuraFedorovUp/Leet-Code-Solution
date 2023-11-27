
import java.util.Map;
import java.util.Stack;

public class Solution {
    int result = 0;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        // test();
        test1();
    }

    private void test() {
        System.out.println((shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)));
    }

    private void test1() {
        System.out.println((shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)));
    }

    public int shipWithinDays(int[] weights, int days) {
        final CargoParameter cargoParameter = getCargoParameters(weights);
        int capacity = getCapacity(cargoParameter, days, weights.length);
        if (days == 1) {
            return cargoParameter.sumWeight;
        }
        fillResult(0, days, weights, 0, capacity);
        return result;
    }

    private boolean fillResult(int currentDay, int days, int[] weights, int index, int capacity) {
        if (currentDay == days) {
            if (index == weights.length) {
                result = capacity;
                return true;
            }
            return false;
        }
        int curWeight = 0;
        for (int i = index; i < weights.length; i++) {
            curWeight += weights[i];
            if (i != weights.length - 1) {
                if (capacity >= curWeight + weights[i + 1]) {
                    continue;
                }
                boolean ans = fillResult(currentDay + 1, days, weights, i + 1, capacity);
                if (ans) {
                    return true;
                }
                if (currentDay == 0) {
                    while (!fillResult(0, days, weights, 0, capacity + 1)) ;
                    return true;
                }
            } else {
                if (capacity >= curWeight) {
                    result = capacity;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private int getCapacity(CargoParameter cargoParameter, int days, int count) {
        final int sumWeight = cargoParameter.sumWeight;
        final int maxWeight = cargoParameter.maxWeight;
        final int averageWeight = cargoParameter.sumWeight / count;
        if (maxWeight > averageWeight - 1) {
            return maxWeight;
        }
        int capacity = sumWeight / days;
        return capacity > 1 ? capacity : 1;
    }

    private CargoParameter getCargoParameters(int[] weights) {
        int sumWeight = 0;
        int maxWeight = 0;
        for (int weight : weights) {
            sumWeight += weight;
            if (weight > maxWeight) {
                maxWeight = weight;
            }
        }
        return new CargoParameter(sumWeight, maxWeight);
    }

    class CargoParameter {
        int sumWeight;
        int maxWeight;

        public CargoParameter(int sumWeight, int maxWeight) {
            this.sumWeight = sumWeight;
            this.maxWeight = maxWeight;
        }
    }
}