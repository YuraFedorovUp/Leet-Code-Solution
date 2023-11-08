class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        final int startY = sy;
        final int startX = sx;
        final int endY = fy;
        final int endX = fx;
        final int dist = t;
        final int distX = Math.abs(startX - endX);
        final int distY = Math.abs(startY - endY);
        final int distMax = Math.max(distX, distY);
        if (distMax == 0) {
            return t !=1;
        }
        return distMax <= t;
    }
}