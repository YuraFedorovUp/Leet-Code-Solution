public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int[][] ans = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        final int result[][] = new int[n][n];
        final int yMax = n;
        final int xMax = n;
        Point point = new Point(0, 0);
        Direction direction = Direction.RIGHT;
        int threshold = 0;
        for (int i = 0; i < n * n; i++) {
            result[point.getY()][point.getX()] = i + 1;
            point = getNextPoint(point, direction, xMax);
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