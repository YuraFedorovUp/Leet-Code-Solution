class Solution {
    public void rotate(int[] nums, int k) {
        final int length = nums.length;
        final int threshold = k % length;
        int clone[] = nums.clone();
        for (int i = 0; i < threshold; i++) {
            nums[i] = clone[length  - threshold+i];
        }
        for (int i = 0; i < length - threshold ; i++) {
            nums[i + threshold] = clone[i];
        }
    }
}