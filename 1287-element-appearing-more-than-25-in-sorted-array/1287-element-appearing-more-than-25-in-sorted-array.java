class Solution {
    public int findSpecialInteger(int[] arr) {
        for (int i = 0; i < arr.length - arr.length / 4; i++) {
            if (arr[i] == arr[i + arr.length / 4]) {
                return arr[i];
            }
        }
        throw new RuntimeException();
    }
}