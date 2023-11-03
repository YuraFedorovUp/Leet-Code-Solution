class Solution {
    public int removeDuplicates(int[] nums) {
        final Set<Integer> distinctNumbers = new HashSet<>();
        for (int number : nums) {
            distinctNumbers.add(number);
        }
        final List<Integer> sortedNumber = new ArrayList<>(distinctNumbers);
        sortedNumber.sort(Comparator.naturalOrder());
        for (int i = 0; i < sortedNumber.size(); i++) {
            nums[i] = sortedNumber.get(i);
        }
        return distinctNumbers.size();
    }
}