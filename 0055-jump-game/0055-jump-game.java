public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        final boolean[] opportunityJumps = new boolean[nums.length];
        opportunityJumps[0] = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!opportunityJumps[i] && i != 0) {
                continue;
            }
            insertJump(i, opportunityJumps, nums);
        }
        return opportunityJumps[nums.length - 1];
    }

    private void insertJump(int index, boolean[] opportunityJumps, int[] nums) {
        final int jumpLength = nums[index];
        for (int i = index + 1; i < index + 1 + jumpLength && i < nums.length; i++) {
            opportunityJumps[i] = true;
        }
    }
}