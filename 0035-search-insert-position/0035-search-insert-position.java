


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            if (left > right) {
                return right + 1;
            }
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (right - left == 1 && nums[left] < target && nums[right] > target) {
                return right;
            } else if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
    }
}