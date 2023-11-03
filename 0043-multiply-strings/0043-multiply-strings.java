public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {

        System.out.println(multiply("123", "456"));
    }


    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        final List<String> intermediateResults = getIntermediateResults(num1, num2);
        final String result = getResult(intermediateResults);
        return result;
    }

    private List<String> getIntermediateResults(String num1, String num2) {
        final List<String> intermediateResults = new ArrayList<>();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String intermediateResult = getIntermediateResult(num1, Integer.valueOf("" + num2.charAt(i)));
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                intermediateResult += "0";
            }
            intermediateResults.add(intermediateResult);
        }
        return intermediateResults;
    }

    private String getIntermediateResult(String num1, int factor) {
        final StringBuilder intermediateResult = new StringBuilder();
        int reminder = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            final int currentFactor = Integer.valueOf("" + num1.charAt(i));
            int product = currentFactor * factor + reminder;
            final StringBuilder productStringBuilder = new StringBuilder(String.valueOf(product));
            if (intermediateResult.length() == 0) {
                intermediateResult.append(productStringBuilder.charAt(productStringBuilder.length() - 1));
            } else {
                intermediateResult.insert(0, productStringBuilder.charAt(productStringBuilder.length() - 1));
            }
            reminder = product / 10;
        }
        if (reminder != 0) {
            intermediateResult.insert(0, reminder);
        }
        return intermediateResult.toString();
    }

    private String getResult(List<String> intermediateResults) {
        int reminder = 0;
        final StringBuilder result = new StringBuilder();
        final int maxLength = getMaxLength(intermediateResults);
        for (int i = 0; i < maxLength; i++) {
            int currentSum = getCurrentSum(intermediateResults, i) + reminder;
            reminder = 0;
            if (currentSum > 9) {
                reminder = currentSum / 10;
                currentSum %= 10;
            }
            result.insert(0, currentSum);
        }
        if (reminder != 0) {
            result.insert(0, reminder);
        }
        return result.toString();
    }

    private int getMaxLength(List<String> intermediateResults) {
        int result = 0;
        for (String intermediateResult : intermediateResults) {
            if (intermediateResult.length() > result) {
                result = intermediateResult.length();
            }
        }
        return result;
    }

    private int getCurrentSum(List<String> intermediateResults, int index) {
        int sum = 0;
        for (String intermediateResult : intermediateResults) {
            int number = getNumber(intermediateResult, index);
            sum += number;
        }
        return sum;
    }

    private int getNumber(String intermediateResult, int index) {
        if (index > intermediateResult.length() - 1) {
            return 0;
        }
        return Integer.valueOf("" + intermediateResult.charAt(intermediateResult.length() - 1 - index));
    }
}