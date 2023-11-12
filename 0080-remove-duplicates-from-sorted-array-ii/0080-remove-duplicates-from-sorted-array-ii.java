public class Solution {
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