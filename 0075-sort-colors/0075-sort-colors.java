import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int nums[] = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        printMy(nums);
    }

    private void printMy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println();
    }

     public void sortColors(int[] nums) {
        int[] buffer1 = Arrays.copyOf(nums, nums.length);
        int[] buffer2 = new int[nums.length];
        int[] result = mergeSort(nums, buffer2, 0, nums.length);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    private int[] mergeSort(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSort(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}