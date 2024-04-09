import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
    }

    private void test0() {
        final int[] tickets = {2, 3, 2};
        final var result = timeRequiredToBuy(tickets, 2);
        System.out.println("ожидаемый   ответ - " + "6");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int[] tickets = {5, 1, 1, 1};
        final var result = timeRequiredToBuy(tickets, 0);
        System.out.println("ожидаемый   ответ - " + "8");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }


    public int timeRequiredToBuy(int[] tickets, int k) {
        var result = 0;
        while (true) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    result++;
                    tickets[i]--;
                }
                if (i == k && tickets[i] == 0) {
                    return result;
                }
            }
        }
    }
}