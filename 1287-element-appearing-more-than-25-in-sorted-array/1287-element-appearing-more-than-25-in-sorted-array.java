class Solution {
    public int findSpecialInteger(int[] arr) {
        int quoter = arr.length / 4;
        for (int i = 0; i < arr.length - quoter; i++) {
            if (arr[i] == arr[i + quoter]) {
                return arr[i];
            }
        }
        throw new RuntimeException();
    }
}