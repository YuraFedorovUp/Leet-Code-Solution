import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
    }

    private void test() {
        final int intervals[][] = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        final int result = findMinArrowShots(intervals);
        System.out.println("ожидаемый   ответ - " + 2);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int intervals[][] = {{1, 2}, {3, 4}, {15, 6}, {7, 8}};
        final int result = findMinArrowShots(intervals);
        System.out.println("ожидаемый   ответ - " + 4);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
        final int intervals[][] = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        final int result = findMinArrowShots(intervals);
        System.out.println("ожидаемый   ответ - " + 2);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test3() {
        final int intervals[][] = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
        // final int intervals[][] = {{-5, -5}, {5,5}};
        final int result = findMinArrowShots(intervals);
        System.out.println("ожидаемый   ответ - " + 2);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test4() {//[[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
        final int intervals[][] = {{9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}};
        // final int intervals[][] = {{-5, -5}, {5,5}};
        final int result = findMinArrowShots(intervals);
        System.out.println("ожидаемый   ответ - " + 2);
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    public int findMinArrowShots(int[][] points) {
        final var xPoints = new ArrayList<Point>();
        for (int[] point : points) {
            xPoints.add(new Point(point[0], point[1]));
        }
        Collections.sort(xPoints);
        final var result = getResult(xPoints);
        return result;
    }

    private int getResult(List<Point> points) {
        if (points.size() == 0) {
            return 0;
        }
        var result = 1;
        long currentEnd = points.get(0).getxEnd();
        for (Point point : points) {
            if (point.getxStart() > currentEnd) {
                result++;
                currentEnd = point.getxEnd();
            }
            if (currentEnd>point.getxEnd()){
                currentEnd=point.getxEnd();
            }
        }
        return result;
    }

    private int castResult(long res) {
        if (res == 0) {
            return 0;
        }
        if (res > 0) {
            return 1;
        }
        return -1;
    }

    class Point implements Comparable<Point> {
        long xStart;
        long xEnd;

        public Point(long xStart, long xEnd) {
            this.xStart = xStart;
            this.xEnd = xEnd;
        }

        public long getxStart() {
            return xStart;
        }

        public long getxEnd() {
            return xEnd;
        }

        @Override
        public int compareTo(Point o) {
            long res = this.xStart - o.xStart;
            if (res != 0) {
                return castResult(res);
            }
            res = this.xEnd - o.getxEnd();
            return castResult(res);
        }
    }
}