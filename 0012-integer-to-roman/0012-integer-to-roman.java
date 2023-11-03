


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    private static final Map<Integer, String> integerToRoman;

    static {
        integerToRoman = new LinkedHashMap<>();
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
    }

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(intToRoman(1994));
    }

    public String intToRoman(int num) {
        int currentNum = num;
        String result = "";
        Iterator<Map.Entry<Integer, String>> entries = integerToRoman.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, String> entry = entries.next();
            int value = entry.getKey();
            String romanValue = entry.getValue();
            while (currentNum >= value) {
                result += romanValue;
                currentNum -= value;
            }
        }
        return result;
    }
}