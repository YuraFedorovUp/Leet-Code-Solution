
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private static Map<Character, Integer> charToQuantity;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        System.out.println(largestGoodInteger("6777133339"));
    }

    private void test1() {
        System.out.println(largestGoodInteger("6777133339"));
    }

    public String largestGoodInteger(String num) {
//        final Queue<Integer> goodIntegers = new PriorityQueue<>();
//        final Map<Character, Integer> digitToQuantity = new HashMap<>();
        char[] chars = num.toCharArray();
        Arrays.sort(chars);
        final Set<Integer> recordedDigit = new HashSet<>();
        int result = -1;
        char resultChar = 2;
        for (int i = 0; i < num.length() - 2; i++) {
            char ch = num.charAt(i);
            if (ch == num.charAt(i+1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                if (resultChar < ch)
                    resultChar = ch ;
            }
        }
        return resultChar == 2 ? "" : String.valueOf(resultChar +""  + resultChar +"" + resultChar);
    }
}