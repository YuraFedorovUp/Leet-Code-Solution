import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
        test2();
    }

    private void test0() {
        final String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        final var result = openLock(deadends, "0202");
        System.out.println("expected - " + "6");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final String[] deadends = {"8888"};
        final var result = openLock(deadends, "0009");
        System.out.println("expected - " + "1");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        final var result = openLock(deadends, "8888");
        System.out.println("expected - " + "-1");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    public int openLock(String[] deadends, String target) {
        final var deadEnds = Arrays.stream(deadends)
                .collect(Collectors.toSet());
        final var startCombinations = new ArrayList<>(List.of("0000"));
        final var result = openLock(0, target, deadEnds, startCombinations, new HashSet<>());
        return result;
    }

    private int openLock(
            int step,
            String target,
            Set<String> deadEnds,
            List<String> startCombinations,
            Set<String> visitedCombinations) {
        if (startCombinations.contains(target)) {
            return step;
        }
        if (startCombinations.size() == 0) {
            return -1;
        }
        final var currentCombinations = new ArrayList<String>();
        for (var startCombination : startCombinations) {
            if (visitedCombinations.contains(startCombination)) {
                continue;
            }
            if (deadEnds.contains(startCombination)) {
                continue;
            }
            visitedCombinations.add(startCombination);
            final var addedCombinations = getAddedCombinations(startCombination);
            currentCombinations.addAll(addedCombinations);
        }
        return openLock(step + 1, target, deadEnds, currentCombinations, visitedCombinations);
    }

    private List<String> getAddedCombinations(String startCombination) {
        final var result = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                final var combination = new StringBuilder(startCombination);
                final var insertChar = getInsertChar(j, combination.charAt(i));
                combination.setCharAt(i, insertChar);
                result.add(combination.toString());
            }
        }
        return result;
    }

    private char getInsertChar(int j, char ch) {
        char result = 0;
        if (j == 0) {
            result = (char) (ch - 1);
            if (result < '0') {
                return '9';
            }
        } else {
            result = (char) (ch + 1);
            if (result > '9') {
                return '0';
            }
        }
        return result;
    }
}