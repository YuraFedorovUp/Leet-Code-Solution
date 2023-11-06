

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        //test();
        test1();
    }

    private void test() {
        ListNode l2 = createNode(0, List.of(3,0,2,6,8,1,7,9,4,2,5,5,0));
        printMy(l2);
        int[][] ans=spiralMatrix(3, 5, l2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <5 ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void test1() {
        ListNode l2 = createNode(0, List.of(0,1,2));
        printMy(l2);
        int[][] ans=spiralMatrix(1, 4, l2);
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j <4 ; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    private ListNode createNode(int step, List<Integer> integers) {
        if (integers.size() == step) {
            return null;
        }
        return new ListNode(integers.get(step), createNode(step + 1, integers));

    }

    private void printMy(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        final int yMax = matrix.length;
        final int xMax = matrix[0].length;
        Point point = new Point(0, 0);
        Direction direction = Direction.RIGHT;
        int threshold = 0;
        for (int i = 0; i < yMax * xMax; i++) {
            result.add(matrix[point.getY()][point.getX()]);
            point = getNextPoint(point, direction, xMax);
            final Direction newDirection = getDirection(point, direction, threshold, yMax, xMax);
            if (direction == Direction.LEFT && newDirection == Direction.UP) {
                threshold++;
            }
            direction = newDirection;
        }
        return result;
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int result[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n ; j++) {
             result[i][j]=-1;
            }
            System.out.println();
        }
        final int yMax = m;
        final int xMax = n;
        Point point = new Point(0, 0);
        ListNode node = head;
        Direction direction = Direction.RIGHT;
        int threshold = 0;
        while (node != null) {
            result[point.getY()][point.getX()] = node.val;
            point = getNextPoint(point, direction, xMax);
            final Direction newDirection = getDirection(point, direction, threshold, yMax, xMax);
            if (direction == Direction.LEFT && newDirection == Direction.UP) {
                threshold++;
            }
            direction = newDirection;
            node = node.next;
        }
        return result;
    }

    private Direction getDirection(Point point, Direction direction, int threshold, int yMax, int xMax) {
        if (direction == Direction.RIGHT && point.getX() == xMax - 1 - threshold) {
            return Direction.DOWN;
        }
        if (direction == Direction.DOWN && point.getY() == yMax - 1 - threshold) {
            return Direction.LEFT;
        }
        if (direction == Direction.LEFT && point.getX() == 0 + threshold) {
            return Direction.UP;
        }
        if (direction == Direction.UP && point.getY() == 0 + threshold) {
            return Direction.RIGHT;
        }
        return direction;
    }

    private Point getNextPoint(Point point, Direction direction, int xMax) {
        switch (direction) {
            case RIGHT:
                if (xMax == 1) {
                    return new Point(point.getY() + 1, point.getX());
                }
                return new Point(point.getY(), point.getX() + 1);
            case DOWN:
                return new Point(point.getY() + 1, point.getX());
            case LEFT:
                return new Point(point.getY(), point.getX() - 1);
            case UP:
                return new Point(point.getY() - 1, point.getX());
        }
        throw new RuntimeException();
    }

    static enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}