
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    private void test() {
        final int intervals[][] = {{1, 4}, {4, 5}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void test1() {
        final int intervals[][] = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void test2() {
        final int intervals[][] = {{1, 4}, {5, 6}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void test3() {
        final int intervals[][] = {{1, 4}, {0, 4}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void test4() {
        final int intervals[][] = {{1, 4}, {5, 5}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void test5() {
        final int intervals[][] = {{1, 4}, {0, 0}};
        final int[][] result = merge(intervals);
        printMy(result);
    }

    private void printMy(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

   public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int start = -1000;
        int end = -1000;
        final List<Integer> intermediateResult = new ArrayList<>();
        for (int[] interval : intervals) {
            if (start == -1000) {
                start = interval[0];
                end = interval[1];
                continue;
            }
            if (interval[0] == start || end >= interval[0]) {
                end = Math.max(end, interval[1]);
            } else {
                intermediateResult.add(start);
                intermediateResult.add(end);
                start = interval[0];
                end = interval[1];
            }
        }

        intermediateResult.add(start);
        intermediateResult.add(end);

        final int[][] result = getResult(intermediateResult);
        return result;
    }

    private int[][] getResult(List<Integer> intermediateResult) {
        final int[][] result = new int[intermediateResult.size() / 2][2];
        for (int i = 0; i < intermediateResult.size(); i++) {
            int y = i / 2;
            int x = i % 2;
            result[y][x] = intermediateResult.get(i);
        }
        return result;
    }
}