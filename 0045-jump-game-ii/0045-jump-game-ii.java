
public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(jump(new int[]{2, 0, 1, 1, 4,}));
    }

    public int jump(int[] nums) {
        final int[] jumpQuantity = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            final int jumpLength = nums[i];
            insertJump(i, jumpLength, jumpQuantity, nums);
        }
        return jumpQuantity[nums.length - 1];
    }

    private void insertJump(int index, int jumpLength, int[] jumpQuantity, int[] nums) {
        final int currentJumpQuantity = jumpQuantity[index] + 1;
        for (int i = index + 1; i < jumpQuantity.length && i < index + jumpLength+1; i++) {
            int oldJumpQuantity = jumpQuantity[i];
            if (oldJumpQuantity == 0) {
                jumpQuantity[i] = currentJumpQuantity;
            } else if (oldJumpQuantity > currentJumpQuantity) {
                jumpQuantity[i] = currentJumpQuantity;
            }
        }
    }
}