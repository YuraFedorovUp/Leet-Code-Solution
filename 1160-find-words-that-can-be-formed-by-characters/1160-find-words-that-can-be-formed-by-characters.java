import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Map<Character, Integer> charToQuantity;

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        System.out.println(countCharacters(new String[]{"catt", "bt", "hat", "tree"}, "atacth"));
    }

    public int countCharacters(String[] words, String chars) {
        charToQuantity = new HashMap<>();
        fillCharToQuantity(chars, charToQuantity);
        final List<Map<Character, Integer>> list = getList(words);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (validWorld(list.get(i))) {
                result += words[i].length();
            }
        }
        return result;
    }

    private boolean validWorld(Map<Character, Integer> charToQuantityWorld) {
        for (Map.Entry<Character, Integer> entry : charToQuantityWorld.entrySet()) {
            char ch = entry.getKey();
            int quantity = entry.getValue();
            if (charToQuantity.getOrDefault(ch, 0) < quantity) {
                return false;
            }
        }
        return true;
    }


    private List<Map<Character, Integer>> getList(String[] words) {
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String world : words) {
            final Map<Character, Integer> charToQuantity = new HashMap<>();
            fillCharToQuantity(world, charToQuantity);
            list.add(charToQuantity);
        }
        return list;
    }

    private void fillCharToQuantity(String world, Map<Character, Integer> charToQuantity) {
        for (int i = 0; i < world.length(); i++) {
            char ch = world.charAt(i);
            charToQuantity.put(ch, charToQuantity.getOrDefault(ch, 0) + 1);
        }
    }
}