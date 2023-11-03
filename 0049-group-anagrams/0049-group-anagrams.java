
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test1();
    }

    private void test1() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1 && strs[0].isEmpty()) {
            final List<String> list = new ArrayList<>();
            list.add("");
            final List<List<String>> result = new ArrayList<>();
            result.add(list);
            return result;
        }
        final Map<String, List<String>> sortWordToWords = getSortWordToWords(strs);
        return new ArrayList<>(sortWordToWords.values());
    }

    private Map<String, List<String>> getSortWordToWords(String[] strs) {
        final Map<String, List<String>> sortWordToWords = new HashMap<>();
        for (String world : strs) {
            final String sortWord = getSortWord(world);
            List<String> words = sortWordToWords.getOrDefault(sortWord, new ArrayList<>());
            words.add(world);
            sortWordToWords.put(sortWord, words);
        }
        return sortWordToWords;
    }

    private String getSortWord(String world) {
        final char[] chars = world.toCharArray();
        Arrays.sort(chars);
        final String sortWord = String.valueOf(chars);
        return sortWord;
    }
}