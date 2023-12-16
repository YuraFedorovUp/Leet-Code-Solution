import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final Map<Character, Integer> sCharToQuantity = getCharToQuantity(s);
        final Map<Character, Integer> tCharToQuantity = getCharToQuantity(t);
        if (sCharToQuantity.size() != tCharToQuantity.size()) {
            return false;
        }
        return sCharToQuantity.entrySet().stream()
                .allMatch(it -> it.getValue().equals(tCharToQuantity.getOrDefault(it.getKey(), -1)));
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