class Solution {
   public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> indexes = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = s.charAt(i);
            if (isVowelBySwitch(ch)) {
                characters.add(ch);
                indexes.add(i);
            }
        }
        Collections.sort(characters);
        System.out.println(characters);
        for (int i = 0; i < characters.size(); i++) {
            chars[indexes.get(i)] = characters.get(i);
        }
        System.out.println(chars);
         String result = "";
        for (char ch : chars) {
            result+=ch;
        }
        return result;
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