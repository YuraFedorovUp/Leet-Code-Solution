import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
   //     System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
   //     System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{3}, {2},{5}}));
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
            point = getNextPoint(point, direction,xMax);
            final Direction newDirection = getDirection(point, direction, threshold, yMax, xMax);
            if (direction == Direction.LEFT && newDirection == Direction.UP) {
                threshold++;
            }
            direction = newDirection;
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
                if (xMax==1){
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