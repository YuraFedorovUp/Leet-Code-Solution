import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
    private static final Map<Character, List<Integer>> directionToChanging;

    static {
        directionToChanging = new HashMap<>();
        directionToChanging.put('E', List.of(0, 1));
        directionToChanging.put('S', List.of(1, 0));
        directionToChanging.put('W', List.of(0, -1));
        directionToChanging.put('N', List.of(-1, 0));
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(isPathCrossing("NES"));
    }

    public boolean isPathCrossing(String path) {
        final Set<Point> usedPoints = new HashSet<>();
        usedPoints.add(new Point(0, 0));
        Point currentPoint = new Point(0, 0);
        for (int i = 0; i < path.length(); i++) {
            final List<Integer> changing = directionToChanging.get(path.charAt(i));
            currentPoint = currentPoint.getNextPoint(changing.get(0), changing.get(1));
            if (usedPoints.contains(currentPoint)) {
                return true;
            }
            usedPoints.add(currentPoint);
        }
        return false;
    }

    private List<Integer> getUsedPoint(int y, int x) {
        final var result = new ArrayList<Integer>();
        result.add(y);
        result.add(x);
        return result;
    }

    class Point {
        private int y;
        private int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

        public Point getNextPoint(Integer dy, Integer dx) {
            return new Point(y + dy, x + dx);
        }
    }
}