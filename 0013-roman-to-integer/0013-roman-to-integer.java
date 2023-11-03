


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    private static final Map<Integer, String> integerToRoman;
    private static final Map<String, Integer> romanToInteger;

    static {
        integerToRoman = new LinkedHashMap<>();
        romanToInteger = new LinkedHashMap<>();
        integerToRoman.put(1000, "M");
        integerToRoman.put(900, "CM");
        integerToRoman.put(500, "D");
        integerToRoman.put(400, "CD");
        integerToRoman.put(100, "C");
        integerToRoman.put(90, "XC");
        integerToRoman.put(50, "L");
        integerToRoman.put(40, "XL");
        integerToRoman.put(10, "X");
        integerToRoman.put(9, "IX");
        integerToRoman.put(5, "V");
        integerToRoman.put(4, "IV");
        integerToRoman.put(1, "I");
        Iterator<Map.Entry<Integer, String>> entries = integerToRoman.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
            romanToInteger.put(entry.getValue(), entry.getKey());
        }
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        String currentRomanString = s;
        int result = 0;
        Iterator<Map.Entry<String, Integer>> entries = romanToInteger.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
            String romanString = entry.getKey();
            int value = entry.getValue();
            while (currentRomanString.startsWith(romanString)) {
                result += value;
                currentRomanString = currentRomanString.substring(romanString.length());
            }
        }
        return result;
    }
}