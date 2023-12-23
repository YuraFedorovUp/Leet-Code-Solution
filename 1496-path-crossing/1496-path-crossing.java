import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        System.out.println(isPathCrossing("NESWW"));
    }


    public boolean isPathCrossing(String path) {
        final Set<List<Integer>> usedPoints = new HashSet<>();
        usedPoints.add(getUsedPoint(0, 0));
        final int[] currentPoint = new int[]{0, 0};
        for (int i = 0; i < path.length(); i++) {
            final List<Integer> changing = directionToChanging.get(path.charAt(i));
            currentPoint[0] += changing.get(0);
            currentPoint[1] += changing.get(1);
            final var usedPoint = getUsedPoint(currentPoint[0], currentPoint[1]);
            if (usedPoints.contains(usedPoint)) {
                return true;
            }
            usedPoints.add(usedPoint);
        }
        return false;
    }

    private List<Integer> getUsedPoint(int y, int x) {
        final var result = new ArrayList<Integer>();
        result.add(y);
        result.add(x);
        return result;
    }
}