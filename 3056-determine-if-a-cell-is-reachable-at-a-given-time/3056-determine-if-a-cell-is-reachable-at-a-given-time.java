class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        final long startY = sy;
        final long startX = sx;
        final long endY = fy;
        final long endX = fx;
        final long dist = t;
        final long distX = Math.abs(startX - endX);
        final long distY = Math.abs(startY - endY);
        final long distMax = Math.max(distX, distY);
        if (distMax == 0) {
             return t !=1;
        }
        return distMax <= t;
    }
}