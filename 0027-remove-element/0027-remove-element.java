class Solution {
     public int removeElement(int[] nums, int val) {
        List<Integer> list = Arrays.stream(nums)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
        while (list.remove(Integer.valueOf(val))) ;
        for (int i = 0; i < nums.length; i++) {
            if (i < list.size()) {
                nums[i] = list.get(i);
            } else {
                nums[i] = -1;
            }
        }
        return list.size();
    }
}