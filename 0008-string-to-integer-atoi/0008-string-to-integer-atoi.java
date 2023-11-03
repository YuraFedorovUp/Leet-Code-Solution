


import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(myAtoi("00000-42a1234"));
    }

    public int myAtoi(String s) {
        final Data data = getData(s);
        int result = getResult(data);

        return result;
    }

    private int getResult(Data data) {
        if (data.getStringNumber().equals("0")) {
            return 0;
        }
        String stringNumber = data.stringNumber;
        if (data.isNegative()) {
            stringNumber = "-" + stringNumber;
        }
        final BigInteger bigInteger = new BigInteger(stringNumber);
        final BigInteger maxInt = new BigInteger(String.valueOf(Integer.MAX_VALUE));
        final BigInteger miInt = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        if (bigInteger.compareTo(maxInt) >= 0) {
            return Integer.MAX_VALUE;
        }
        if (bigInteger.compareTo(miInt) <= 0) {
            return Integer.MIN_VALUE;
        }
        return bigInteger.intValue();
    }

    private Data getData(String s) {
        final boolean isNegative = getNegative(s);
        final String stringNumber = getStringNumber(s);
        return new Data(stringNumber, isNegative);

    }

    private String getStringNumber(String s) {
        s = s.trim();
        boolean firstSymbol = false;
        boolean startReading = false;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                startReading = true;
                sb.append(ch);
            } else if (startReading) {
                break;
            } else if (ch == '-' || ch == '+') {
                if (firstSymbol == true) {
                    sb = new StringBuilder("");
                    break;
                }
                firstSymbol = true;
                continue;
            } else {
                break;
            }
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    private boolean getNegative(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                return false;
            }
            if (ch == '-') {
                return true;
            }
        }
        return false;
    }

    class Data {
        private String stringNumber;
        private boolean isNegative;

        public Data(String stringNumber, boolean isNegative) {
            this.stringNumber = stringNumber;
            this.isNegative = isNegative;
        }

        public String getStringNumber() {
            return stringNumber;
        }

        public boolean isNegative() {
            return isNegative;
        }
    }
}