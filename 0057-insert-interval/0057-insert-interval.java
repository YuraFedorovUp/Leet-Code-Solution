import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        final int intervals[][] = {{1,3},{6,9}};
        final int[][] result = insert(intervals, new int[]{2,5});
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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = -1000;
        int end = -1000;
        intervals = addNewInterval(intervals, newInterval);
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
        return getResult(intermediateResult);
    }

    private int[][] addNewInterval(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = intervals[i][j];
            }
        }
        result[intervals.length][0] = newInterval[0];
        result[intervals.length][1] = newInterval[1];
        Arrays.sort(result, Comparator.comparingInt(i -> i[0]));
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