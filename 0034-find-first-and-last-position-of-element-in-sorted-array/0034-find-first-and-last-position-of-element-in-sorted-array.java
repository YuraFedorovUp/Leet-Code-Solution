


import java.util.ArrayList;
import java.util.List;

public class Solution {   

    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0){
            return new int[]{-1, -1};
        }
        int left = searchLeftRange(nums, target);
        int right = searchRightRange(nums, target);
        return new int[]{left, right};
    }

    private int searchRightRange(int[] nums, int target) {
        if (nums[nums.length-1]==target){
            return nums.length-1;
        }
        int left = 0;
        int right = nums.length-1;
        int result = Integer.MIN_VALUE;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target && result < middle) {
                result = middle;
            }
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    private int searchLeftRange(int[] nums, int target) {
        if (nums[0]==target){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        int result = Integer.MAX_VALUE;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target && result > middle) {
                result = middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}