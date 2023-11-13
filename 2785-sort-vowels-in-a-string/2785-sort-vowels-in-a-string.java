class Solution {
  public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = s.charAt(i);
            if (isVowelBySwitch(ch)) {
                characters.add(ch);
            }
        }
        Collections.sort(characters);
        StringBuilder result = new StringBuilder(s.length());
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowelBySwitch(s.charAt(i))) {
                result.append(characters.get(j++));
            }else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    boolean isVowelBySwitch(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}