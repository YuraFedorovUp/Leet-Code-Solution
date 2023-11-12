import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution main = new Solution();
        main.start();
    }

    private void start() {
        test();
        test1();
    }

    private void test() {
        final int[][] routes = new int[][]{{1, 2, 7}, {3, 6, 7}};
        System.out.println(numBusesToDestination(routes, 1, 6));
    }

    private void test1() {
        final int[][] routes = new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        System.out.println(numBusesToDestination(routes, 15, 12));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        if (!isVAlidTarget(routes, target)) {
            return -1;
        }
        final Map<Integer, List<List<Integer>>> busStopToBusStops = getbusStopToBusStops(routes);
        Set<Integer> usedBusStop = new HashSet<>();
        usedBusStop.add(source);
        List<List<Integer>> value = busStopToBusStops.get(source);
        List<Integer> busStops = getBusStops(value, usedBusStop);
        usedBusStop.addAll(busStops);
        int step = 1;
        while (busStops.size() != 0) {
            if (busStops.contains(target)) {
                return step;
            }
            final List<Integer> newBusStops = new ArrayList<>();
            for (int busStop : busStops) {
                List<Integer> stops = getBusStops(busStopToBusStops.get(busStop), usedBusStop);
                newBusStops.addAll(stops);
                usedBusStop.addAll(stops);
            }
            busStops = newBusStops;
            step++;
        }
        return -1;
    }

    private boolean isVAlidTarget(int[][] routes, int target) {
        for (int[] rout : routes) {
            for (int r : rout) {
                if (target == r) {
                    return true;
                }
            }
        }
        return false;
    }


    private List<Integer> getBusStops(List<List<Integer>> value, Set<Integer> usedBusStop) {
        if (value == null) {
            return new ArrayList<>();
        }
        return value.stream()
                .flatMap(it -> it.stream())
                .distinct()
                .filter(it -> !usedBusStop.contains(it))
                .collect(Collectors.toList());
    }

    private Map<Integer, List<List<Integer>>> getbusStopToBusStops(int[][] routes) {
        final Map<Integer, List<List<Integer>>> busStopToBusStops = new HashMap<>();
        for (int[] rout : routes) {
            if (rout.length <= 1) {
                continue;
            }
            final List<Integer> busStops = getBusStops(rout);
            for (int i = 0; i < rout.length; i++) {
                busStops.remove(Integer.valueOf(rout[i]));
                List<List<Integer>> value = busStopToBusStops.getOrDefault(rout[i], new ArrayList<>());
                value.add(new ArrayList<>(busStops));
                busStopToBusStops.put(rout[i], value);
                busStops.add(rout[i]);
            }
        }
        return busStopToBusStops;
    }

    private List<Integer> getBusStops(int[] rout) {
        final List<Integer> results = new ArrayList<>();
        for (int i = 0; i < rout.length; i++) {
            results.add(rout[i]);
        }
        return results;
    }
}