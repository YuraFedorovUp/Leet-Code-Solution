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
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i'
                || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}