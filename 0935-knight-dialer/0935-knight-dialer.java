


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static final int MODULO = 1_000_000_000 + 7;
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
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
    }

    private void test() {
        System.out.println(knightDialer(1));
    }

    private void test1() {
        System.out.println(knightDialer(2));
    }

    private void test2() {
        System.out.println(knightDialer(3));
    }

    private void test3() {
        System.out.println(knightDialer(3131));
    }

    private void test4() {
        for (int i = 10; i < 3000; i++) {
            System.out.println("i=   " + i + "   +" + knightDialer(i));

        }
    }

    public int knightDialer(int n) {
        int ans = 0;
        final long[][] variants = getVariants(n);
        return getSum(variants, n);
    }

    private long[][] getVariants(int n) {
        final long[][] variants = new long[n + 2][10];
        variants[0] = getVariansFirstStep();
        fillVariants(variants, n);
        return variants;
    }

    private int getSum(long[][] variants, int n) {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += variants[n - 1][i];
            ans %= MODULO;
        }
        return ans;
    }

    private long[] getVariansFirstStep() {
        final long[] variantsForFirstStep = new long[10];
        for (int i = 0; i < 10; i++) {
            variantsForFirstStep[i] = 1;
        }
        return variantsForFirstStep;
    }

    private void fillVariants(long[][] variants, int n) {
        for (int i = 1; i < n; i++) {
            fillIVariants(variants, i);
        }
    }

    private void fillIVariants(long[][] variants, int index) {
        for (int i = 0; i < 10; i++) {
            final long cur = variants[index - 1][i] % MODULO;
            final List<Integer> nextIndexes = indexToNextIndexes.get(i);
            for (int it : nextIndexes) {
                variants[index][it] = (variants[index][it] + cur) % MODULO;
                variants[index][it] %= MODULO;
            }
        }
    }


}