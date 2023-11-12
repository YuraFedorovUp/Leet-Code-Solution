public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
        test2();
        test3();
        test4();
    }

    private void test() {
        final int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);
        printMy(nums, k);
    }

    private void test1() {
        final int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        printMy(nums, k);
    }


    private void test2() {
        final int[] nums = new int[]{0,0,1,1};
        int k = removeDuplicates(nums);
        printMy(nums, k);
    }
    private void test3() {
        final int[] nums = new int[]{0,0,1,1,1};
        int k = removeDuplicates(nums);
        printMy(nums, k);
    }
    private void test4() {
        final int[] nums = new int[]{0,0,1};
        int k = removeDuplicates(nums);
        printMy(nums, k);
    }

    private void printMy(int[] nums, int k) {
        System.out.println("k = " + k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(i >= k ? -1 : nums[i]);
        }
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int size = 1;
        int lastNumber = nums[0];
        int countLastNumber = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (currentNumber != lastNumber) {
                lastNumber = currentNumber;
                countLastNumber = 1;
                swap(nums, size, i);
                size++;
                continue;
            }
            countLastNumber++;
            if (countLastNumber < 3) {
                swap(nums, size, i);
                size++;
            }
        }
        return size;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}