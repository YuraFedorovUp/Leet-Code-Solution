public class Solution {   

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return countAndSay(1, n, new StringBuilder("1"));
    }

    private String countAndSay(int step, int maxStep, StringBuilder previousResult) {
        if (step == maxStep) {
            return previousResult.toString();
        }
        StringBuilder currentResult = new StringBuilder();
        for (int i = 0; i < previousResult.length(); i++) {
            char ch = previousResult.charAt(i);
            int quantity = getQuantity(ch, i, previousResult);
            currentResult.append(quantity);
            currentResult.append(ch);
            i += quantity-1;
        }
        return countAndSay(step + 1, maxStep, currentResult);
    }

    private int getQuantity(char ch, int firstIndex, StringBuilder previousResult) {
        int result = 0;
        for (int i = firstIndex; i < previousResult.length(); i++) {
            if (ch != previousResult.charAt(i)) {
                break;
            }
            result++;
        }
        return result;
    }
}