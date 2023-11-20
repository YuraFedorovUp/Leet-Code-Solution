import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> garbageToMaxHouseIndexes = new HashMap<>();
    private static List<Map<Character, Integer>> garbageToQuantityGarbageHouses = new ArrayList<>();

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
    }

    private void test() {
        String garbage[] = new String[]{"G","P","GP","GG"};
        int traval[] = new int[]{2,4,3};
        System.out.println(garbageCollection(garbage, traval));
    }

    private void test1() {
        String garbage[] = new String[]{"MMM","PGM","GP"};
        int traval[] = new int[]{3,10};
        System.out.println(garbageCollection(garbage, traval));
    }

    private void test2() {
        String garbage[] = new String[]{"","",""};
        int traval[] = new int[]{3,10};
        System.out.println(garbageCollection(garbage, traval));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        garbageToMaxHouseIndexes = new HashMap<>();
        garbageToQuantityGarbageHouses = getGarbageToQuantityGarbageHouses(garbage);
        int result = countCleaningGarbage('P', travel);
        result += countCleaningGarbage('G', travel);
        result += countCleaningGarbage('M', travel);
        return result;
    }

    private List<Map<Character, Integer>> getGarbageToQuantityGarbageHouses(String[] garbage) {
        final List<Map<Character, Integer>> garbageToQuantityGarbageHouses = new ArrayList<>();
        for (int j = 0; j < garbage.length; j++) {
            final String currentGarbage = garbage[j];
            Map<Character, Integer> garbageToQuantityGarbage = new HashMap<>();
            for (int i = 0; i < currentGarbage.length(); i++) {
                final char ch = currentGarbage.charAt(i);
                garbageToMaxHouseIndexes.put(ch, j);
                final int quantity = garbageToQuantityGarbage.getOrDefault(ch, 0) + 1;
                garbageToQuantityGarbage.put(ch, quantity);
            }
            garbageToQuantityGarbageHouses.add(garbageToQuantityGarbage);
        }
        return garbageToQuantityGarbageHouses;
    }

    private int countCleaningGarbage(char currentGarbage, int[] travel) {
        final int lastIndex = garbageToMaxHouseIndexes.getOrDefault(currentGarbage, -1);
        int result = 0;
        for (int i = 0; i <= lastIndex; i++) {
            int priceOfMoving = 0;
            if (i != lastIndex) {
                priceOfMoving = travel[i];
            }
            int priceOfCleaning = garbageToQuantityGarbageHouses.get(i).getOrDefault(currentGarbage, 0);
            result += priceOfMoving + priceOfCleaning;
        }
        return result;
    }
}