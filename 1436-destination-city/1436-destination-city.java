import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
    }

    private void test() {
        final List<String> paths0 = List.of("London", "New York");
        final List<String> paths1 = List.of("New York", "Lima");
        final List<String> paths2 = List.of("Lima", "Sao Paulo");
        final List<List<String>> paths = List.of(paths0, paths1, paths2);
        System.out.println(destCity(paths));
    }

    public String destCity(List<List<String>> paths) {
        final Set<String> startCities = new HashSet<>();
        final Set<String> goalCities = new HashSet<>();
        for (List<String> path : paths) {
            startCities.add(path.get(0));
            goalCities.add(path.get(1));
        }
        for (String goalCity : goalCities) {
            if (!startCities.contains(goalCity)) {
                return goalCity;
            }
        }
        throw new RuntimeException();
    }
}