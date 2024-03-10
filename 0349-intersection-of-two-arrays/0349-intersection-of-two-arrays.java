


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        int[] nums1 = new int[]{1, 2, 3, 3, 1, 2};
        int[] nums2 = new int[]{2, 2};
        int[] result = intersection(nums1, nums2);
        printMy(result);
    }

    private void printMy(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        final Set<Integer> set1 = map(nums1);
        final Set<Integer> set2= map(nums2);
        final List<Integer> result = new ArrayList<>();
        for (int num:set2){
            if (set1.contains(num)){
                result.add(num);
            }
        }
        int res []=new int[result.size()];
        for (int i=0;i<result.size();i++){
            res[i]=result.get(i);
        }
        return res;
    }

    private Set<Integer> map(int[] nums) {
        final Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }

}