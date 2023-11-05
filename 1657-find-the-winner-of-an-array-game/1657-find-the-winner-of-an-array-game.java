import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(getWinner(new int[]{3, 2, 1}, 10));
    }

    public int getWinner(int[] arr, int k) {
        int round = 0;
        final LinkedList<Integer> list = getList(arr);
        final int max = getMax(list);
        int winner = list.get(0);
        while (round != k) {
            if (winner == max) {
                return max;
            }
            int pretnendent = list.get(1);
            if (winner > pretnendent) {
                round++;
                list.remove(1);
                list.add(pretnendent);
            } else {
                round = 1;
                list.remove(0);
                list.add(winner);
                winner = pretnendent;
            }
        }

        return winner;
    }

    private int getMax(LinkedList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int n : list) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    private LinkedList<Integer> getList(int[] arr) {
        final LinkedList<Integer> list = new LinkedList<>();
        for (int n : arr) {
            list.add(n);
        }
        return list;
    }
}