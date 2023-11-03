

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    public static List<Integer> convertToList(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int e : arr) {
            result.add(e);
        }
        return result;
    }

    private void start() {
        test1();
    }

    private void test1() {
        int[] n1 = new int[]{1, 3};
        int[] n2 = new int[]{2};
        System.out.println(findMedianSortedArrays(n1, n2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //  List<Integer> n1 = new ArrayList<>();
        List<Integer> n1 = convertToList(nums1);
        n1.addAll(convertToList(nums2));
        n1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        double value = getResult(n1);


//        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
//        BigDecimal result = new BigDecimal(value, context);
//        System.out.println(result);
//        return Double.valueOf(result.doubleValue());
        return value;
    }

    private double getResult(List<Integer> treeSet) {
        int size = treeSet.size();
        if (size % 2 == 1) {
            return getElement(treeSet, size / 2);
        }
        double res = (getElement(treeSet, (size / 2) - 1) + getElement(treeSet, (size / 2))) / 2;
        return res;
    }

    private double getElement(List<Integer> treeSet, int i) {
        int z = 0;
        for (int element : treeSet) {
            if (z++ == i) {
                return element;
            }
        }
        throw new RuntimeException();
    }
}
