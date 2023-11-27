import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final int[][] variants;
    private static final int MODULO = 1_000_000_007;
    private static final Map<Integer, List<Integer>> indexToNextIndexes;

    static {
        indexToNextIndexes = new HashMap<>();
        indexToNextIndexes.put(0, List.of(4, 6));
        indexToNextIndexes.put(1, List.of(6, 8));
        indexToNextIndexes.put(2, List.of(7, 9));
        indexToNextIndexes.put(3, List.of(4, 8));
        indexToNextIndexes.put(4, List.of(0, 3, 9));
        indexToNextIndexes.put(5, List.of());
        indexToNextIndexes.put(6, List.of(0, 1, 7));
        indexToNextIndexes.put(7, List.of(2, 6));
        indexToNextIndexes.put(8, List.of(1, 3));
        indexToNextIndexes.put(9, List.of(2, 4));
        variants = getVariants(5002);
    }
    
    private static int[][] getVariants(int n) {
        final int[][] variants = new int[n + 2][10];
        variants[0] = getVariansFirstStep();
        fillVariants(variants, n);
        return variants;
    }

    private static int[] getVariansFirstStep() {
        final int[] variantsForFirstStep = new int[10];
        for (int i = 0; i < 10; i++) {
            variantsForFirstStep[i] = 1;
        }
        return variantsForFirstStep;
    }

    private static void fillVariants(int[][] variants, int n) {
        for (int i = 1; i < n; i++) {
            fillIVariants(variants, i);
        }
    }

    private static void fillIVariants(int[][] variants, int index) {
        for (int i = 0; i < 10; i++) {
            final int cur = variants[index - 1][i] % MODULO;
            final List<Integer> nextIndexes = indexToNextIndexes.get(i);
            for (int it : nextIndexes) {
                variants[index][it] = (variants[index][it] + cur) % MODULO;
            }
        }
    }

    public int knightDialer(int n) {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans = (ans + variants[n - 1][i]) % MODULO;
        }
        return ans;
    }
}