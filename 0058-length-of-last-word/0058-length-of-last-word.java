class Solution {
    public int lengthOfLastWord(String s) {
        final String[] ss = s.split("\\ ", -1);
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].trim().length() != 0) {
                return ss[i].length();
            }
        }
        return 0;
    }
}