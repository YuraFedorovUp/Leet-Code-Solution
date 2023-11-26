public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int nums[] = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int number = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                number = nums[i];
                count = 1;
            } else if (nums[i] == number) {
                count++;
            } else {
                count--;
            }
        }


        return number;
    }
}