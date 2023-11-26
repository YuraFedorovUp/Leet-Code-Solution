import java.util.Arrays;


public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
//        test();
//        test1();
        test2();
    }

    private void test() {
        int nums0[] = new int[]{3, 0, 6, 1, 5};
        System.out.println(hIndex(nums0));
    }

    private void test1() {
        int nums0[] = new int[]{100};
        System.out.println(hIndex(nums0));
    }

    private void test2() {
        int nums0[] = new int[]{1, 7, 9, 4};
        System.out.println(hIndex(nums0));
    }

    public int hIndex(int[] citations) {
        final int length = citations.length;
        Arrays.sort(citations);
        reverse(citations);
        int maximumValue = 0;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            if (citations[i] == 0) {
                break;
            }
            maximumValue++;
            if (citations[i] <= maximumValue) {
                temp = Math.max(temp, citations[i]);
            }
            if (citations[i] > i) {
                temp = Math.max(temp, i + 1);
            }
        }
        return temp;
    }

    private void reverse(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            swap(citations, left++, right--);
        }
    }

    private void swap(int[] citations, int left, int right) {
        int temp = citations[left];
        citations[left] = citations[right];
        citations[right] = temp;
    }
}