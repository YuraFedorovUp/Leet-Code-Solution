public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int[][] ans = spiralMatrixIII(5,6,1,4);
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        final int yMax = rows;
        final int xMax = cols;
        int result[][] = new int[yMax*xMax][2];
        Point point = new Point(rStart, cStart);
        Direction direction = Direction.RIGHT;
        int threshold = 0;
        int means = 0;
        while (means < yMax * xMax) {
            if (isValidPoint(point, yMax, xMax)) {
                result[means][0] =point.getY();
                result[means][1] =point.getX();
                means++;
            }


                point = getNextPoint(point, direction, xMax);
                final Direction newDirection = getDirection(point, direction, threshold, rStart, cStart);
                if (direction == Direction.LEFT && newDirection == Direction.UP) {
                    threshold++;
                }
                direction = newDirection;

        }
        return result;
    }

    private boolean isValidPoint(Point point, int yMax, int xMax) {
        final int x = point.getX();
        final int y = point.getY();
        return (x >= 0 && x < xMax) && (y >= 0 && y < yMax);
    }

    private Direction getDirection(Point point, Direction direction, int threshold, int yStart, int xStart) {
        if (direction == Direction.RIGHT && point.getX() == xStart + 1 + threshold) {
            return Direction.DOWN;
        }
        if (direction == Direction.DOWN && point.getY() == yStart + 1 + threshold) {
            return Direction.LEFT;
        }
        if (direction == Direction.LEFT && point.getX() == xStart -1-threshold) {
            return Direction.UP;
        }
        if (direction == Direction.UP && point.getY() == yStart - threshold) {
            return Direction.RIGHT;
        }
        return direction;
    }

    private Point getNextPoint(Point point, Direction direction, int xMax) {
        switch (direction) {
            case RIGHT:
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