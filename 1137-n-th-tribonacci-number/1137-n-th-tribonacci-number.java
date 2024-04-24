class Solution {
    private static final int[] tribonacciNumbers;

    static {
        tribonacciNumbers = new int[38];
        for (int i = 1; i < 38; i++) {
            tribonacciNumbers[i] = getTribonacciNumber(i, tribonacciNumbers);
        }
    }

    private static int getTribonacciNumber(int index, int[] tribonacciNumbers) {
        if (index == 1 || index == 2) {
            return 1;
        }
        int tribonacciNumber = 0;
        for (int i = 0; i < 3; i++) {
            final var currentIndex = index - i - 1;
            if (currentIndex < 0) {
                break;
            }
            tribonacciNumber += tribonacciNumbers[currentIndex];
        }
        return tribonacciNumber;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
    }

    private void test0() {
        final var result = tribonacci(4);
        System.out.println("expected - " + "4");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final var result = tribonacci(25);
        System.out.println("expected - " + "1389537");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    public int tribonacci(int n) {
        return tribonacciNumbers[n];
    }
}