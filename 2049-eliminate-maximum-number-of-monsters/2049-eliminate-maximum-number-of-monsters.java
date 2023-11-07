

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private static int result;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    public void start() {
        System.out.println(eliminateMaximum(
                new int[]{46, 33, 44, 42, 46, 36, 7, 36, 31, 47, 38, 42, 43, 48, 48, 25, 28, 44, 49, 47, 29, 32, 30, 6, 42, 9, 39, 48, 22, 26, 50, 34, 40, 22, 10, 45, 7, 43, 24, 18, 40, 44, 17, 39, 36},
                new int[]{1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 1, 3, 2, 2, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 8, 1, 1, 1, 3, 6, 1, 3, 1, 1}));
        System.out.println(eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
        System.out.println(eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));
        System.out.println(eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(eliminateMaximum(new int[]{1, 2}, new int[]{1, 5}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
     //   System.out.println();
        // int killedMonsters = 0;
        int monstersQuantity = dist.length;
        List<Integer> killedMonsters = new ArrayList<>();
        final int maxSteps[] = getMaxSteps(dist, speed, monstersQuantity);
        Arrays.sort(maxSteps);
      //  printArr(dist);
     //   printArr(speed);
      //  printArr(maxSteps);
        List<Integer> list = new ArrayList<>();
        for (int step = 0; step < monstersQuantity; step++) {
            if (maxSteps[step] < step + 1) {
                return step ;
            }
 
            list.add(step);

        }
        return monstersQuantity;
    }

    private int[] getMaxSteps(int[] dist, int[] speed, int monstersQuantity) {
        final int maxSteps[] = new int[monstersQuantity];
        for (int i = 0; i < monstersQuantity; i++) {
            maxSteps[i] = dist[i] / speed[i] + 1;
            if (dist[i] % speed[i] == 0) {
                maxSteps[i]--;
            }
        }
        return maxSteps;
    }

    private void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}