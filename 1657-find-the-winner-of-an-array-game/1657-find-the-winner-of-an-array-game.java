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
        final int max = getMax(arr);
        if (k == arr.length) {
            return max;
        }
        int winner = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (winner > arr[i]) {
                round++;
            }else {
                winner=arr[i];
                round=1;
            }
            if (round==k){
                return winner;
            }
        }
        return winner;
    }

    private int getMax(int[] list) {
        int max = Integer.MIN_VALUE;
        for (int n : list) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }
}