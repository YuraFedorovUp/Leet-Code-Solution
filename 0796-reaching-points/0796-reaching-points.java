import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    int yMin;
    int yMax;
    int xMin;
    int xMax;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(reachingPoints(1,1,1,1));
    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && (ty - sy) % sx == 0) return true;
        if (sy == ty && (tx - sx) % sy == 0) return true;
        return reachingPoints(sx, sy, tx % ty, ty % tx);
    }
}