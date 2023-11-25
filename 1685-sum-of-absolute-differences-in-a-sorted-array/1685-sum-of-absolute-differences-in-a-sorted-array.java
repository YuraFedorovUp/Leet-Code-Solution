import java.util.Arrays;

public class Solution {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        final int length = nums.length;
        final int[] results = new int[length];
        final int prefix[] = new int[length];
        prefix[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < length; i++) {
            final int leftCount = i == 0 ? 0 : i;
            final int rightCount = i == length - 1 ? 0 : length - 1 - i;

            final int leftSum = i == 0 ? 0 : prefix[i - 1];
            final int rightSum = i == length - 1 ? 0 : prefix[length - 1] - prefix[i];

            results[i] = leftCount * nums[i] - leftSum + rightSum - rightCount * nums[i];
        }
        return results;
    }
}