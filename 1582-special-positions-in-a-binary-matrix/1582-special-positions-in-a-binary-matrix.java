import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSpecial(int[][] mat) {

        final Set<Integer> xUniqs = new HashSet<>();
        int result = 0;
        for (int i = 0; i < mat.length; i++) {
            int curXUniq = -1;
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    curXUniq = j;
                    count++;
                    if (count > 1) {
                        continue;
                    }
                }
            }
            if (count == 1) {
                xUniqs.add(curXUniq);
            }
        }

        for (int x : xUniqs) {
            int count = 0;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][x] == 1) {
                    count++;
                }
            }
            if (count == 1) {
                result++;
            }
        }
        return result;
    }
}