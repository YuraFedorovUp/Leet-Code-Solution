class Solution {
  public List<String> buildArray(int[] target, int n) {
        final List<String> results = new ArrayList<>();
        final Stack<Integer> stack = new Stack<>();
        int i = 0;
        int streamNumber = 1;
        while (i < target.length) {
            stack.push(streamNumber);
            streamNumber++;
            results.add("Push");
            if (stack.peek() == target[i]) {
                i++;
            } else {
                stack.pop();
                results.add("Pop");
            }
        }
        return results;
    }
}