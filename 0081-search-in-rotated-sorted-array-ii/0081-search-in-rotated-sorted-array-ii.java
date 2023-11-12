class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int r = Arrays.binarySearch(nums, target);
        return r >= 0;
    }
}