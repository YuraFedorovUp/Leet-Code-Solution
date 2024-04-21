import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        test0();
        test1();
        test2();
    }

    private void test0() {
        final int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        final var result = validPath(3, edges, 0, 2);
        System.out.println("expected - " + "true");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test1() {
        final int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        final var result = validPath(6, edges, 0, 5);
        System.out.println("expected - " + "false");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    private void test2() {
       // final int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};
        final int[][] edges = {{4,0},{0,9},{5,4}};
        final var result = validPath(10, edges, 5, 9);
        System.out.println("expected - " + "true");
        System.out.println("actual   - " + result);
        System.out.println("//////////////////////");
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) {
            return true;
        }
        final Map<Integer, List<Integer>> fromToEdges = getFromToEdges(edges);
        final boolean result = validPath(fromToEdges, source, destination, new HashSet<Integer>());
        return result;
    }

    private Map<Integer, List<Integer>> getFromToEdges(int[][] edges) {
        final Map<Integer, List<Integer>> fromToEdges = new HashMap<>();
        for (var edge : edges) {
            addEdge(fromToEdges, edge[0], edge[1]);
            addEdge(fromToEdges, edge[1], edge[0]);
        }
        return fromToEdges;
    }

    private void addEdge(Map<Integer, List<Integer>> fromToEdges, int startVertex, int endVertex) {
        final var endVertexes = fromToEdges.getOrDefault(startVertex, new ArrayList<>());
        endVertexes.add(endVertex);
        fromToEdges.put(startVertex, endVertexes);
    }

    private boolean validPath(
            Map<Integer, List<Integer>> fromToEdges,
            int source,
            int destination,
            HashSet<Integer> visitedVertexes) {
        if (visitedVertexes.contains(destination)) {
            return true;
        }
        if (visitedVertexes.contains(source)) {
            return false;
        }
        visitedVertexes.add(source);
        final var endVertexes = fromToEdges.getOrDefault(source, new ArrayList<>());
        for (var endVertex : endVertexes) {
            if (validPath(fromToEdges, endVertex, destination, visitedVertexes)) {
                return true;
            }
        }
        return false;
    }
}