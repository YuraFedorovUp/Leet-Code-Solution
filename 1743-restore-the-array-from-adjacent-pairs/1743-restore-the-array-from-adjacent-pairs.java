import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        final int intervals[][] = {{2, 1}, {3, 4}, {3, 2}};
        final int[] result = restoreArray(intervals);
        printMy(result);
    }

    private void test1() {
        final int intervals[][] = {{4, -2}, {1, 4}, {-3, 1}};
        final int[] result = restoreArray(intervals);
        printMy(result);

    }

    private void printMy(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        final List<Integer> intermediateResult = new ArrayList<>();
        final Set<Integer> usedIndexes = new HashSet<>();
        final Map<Integer, List<Integer>> numberToIndexes = getNumberToIndexes(adjacentPairs);
        final int uniqNumber = getUniqNumber(numberToIndexes);
        intermediateResult.add(uniqNumber);
        final int index = numberToIndexes.get(uniqNumber).get(0);
        final int first = adjacentPairs[index][0];
        final int second = adjacentPairs[index][1];
        int nextNumber = first == uniqNumber ? second : first;
        usedIndexes.add(index);
        while (true) {
            final List<Integer> indexes = numberToIndexes.get(nextNumber);
            if (indexes.size() == 1) {
                final int currentFirst = adjacentPairs[indexes.get(0)][0];
                final int currentSecond = adjacentPairs[indexes.get(0)][1];

                intermediateResult.add(nextNumber);
                break;
            }
            int i = usedIndexes.contains(indexes.get(0)) ? indexes.get(1) : indexes.get(0);

            final int currentFirst = adjacentPairs[i][0];
            final int currentSecond = adjacentPairs[i][1];
            intermediateResult.add(nextNumber);
            if (nextNumber == currentFirst) {
                nextNumber = currentSecond;
            } else {
                nextNumber = currentFirst;
            }
            usedIndexes.add(i);

        }
        return getResult(intermediateResult);
    }

    private Map<Integer, List<Integer>> getNumberToIndexes(int[][] adjacentPairs) {
        final Map<Integer, List<Integer>> numberToIndexes = new HashMap<>();
        for (int i = 0; i < adjacentPairs.length; i++) {
            final int first = adjacentPairs[i][0];
            final int second = adjacentPairs[i][1];
            put(first, i, numberToIndexes);
            put(second, i, numberToIndexes);
        }
        return numberToIndexes;
    }

    private void put(int number, int index, Map<Integer, List<Integer>> numberToIndexes) {
        List<Integer> indexes = numberToIndexes.getOrDefault(number, new ArrayList<>());
        indexes.add(index);
        numberToIndexes.put(number, indexes);
    }

    private int getUniqNumber(Map<Integer, List<Integer>> numberToIndexes) {
        return numberToIndexes.entrySet().stream()
                .filter(it -> it.getValue().size() == 1)
                .map(it -> it.getKey())
                .findFirst().orElseThrow();
    }

    private int[] getResult(List<Integer> intermediateResult) {
        final int[] result = new int[intermediateResult.size()];
        for (int i = 0; i < intermediateResult.size(); i++) {
            result[i] = intermediateResult.get(i);
        }
        return result;
    }
}