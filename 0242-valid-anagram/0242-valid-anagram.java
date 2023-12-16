

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final Map<Character, Integer> sCharToQuantity = getCharToQuantity(s);
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            Integer value=sCharToQuantity.get(ch);
            if (value==null||value==0){
                return false;
            }
            sCharToQuantity.put(ch, value-1);
        }
        return sCharToQuantity.entrySet().stream()
                .allMatch(it -> it.getValue().equals(0));
    }

    private Map<Character, Integer> getCharToQuantity(String world) {
        Map<Character, Integer> charToQuantity = new HashMap<>();
        for (int i = 0; i < world.length(); i++) {
            char ch = world.charAt(i);
            charToQuantity.put(ch, charToQuantity.getOrDefault(ch, 0) + 1);
        }
        return charToQuantity;
    }
}