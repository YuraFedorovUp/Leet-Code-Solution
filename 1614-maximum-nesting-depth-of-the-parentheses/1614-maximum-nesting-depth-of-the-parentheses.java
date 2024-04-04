
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
    }

    private void test0() {
        //final int[] nums = {10, 5, 2, 6};
        final var result = maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println("ожидаемый   ответ - " + "3");
        System.out.println("фактический ответ - " + result);
        System.out.println("//////////////////////");
    }

    public int maxDepth(String s) {
        var result = 0;
        var count = 0;
        for (int i = 0; i < s.length(); i++) {
            final var ch = s.charAt(i);
            if (ch == '(') {
                count++;
                result = Math.max(count, result);
            } else if (ch == ')'){
                count--;
            }
        }
        return result;
    }
}