  class Graph {
        private final Map<Integer, List<Edge>> numberToEdges;
        private final int size;
        private boolean[] used = new boolean[1];

        public Graph(int n, int[][] edges) {
            numberToEdges = new HashMap<>();
            size = n;
            for (int i = 0; i < edges.length; i++) {
                addEdge(edges[i]);

            }
        }

        public void addEdge(int[] edge) {
            final int number = edge[0];
            final Edge nextEdg = new Edge(edge[1], edge[2]);
            List<Edge> edges1 = numberToEdges.getOrDefault(number, new ArrayList<>());
            edges1.add(nextEdg);
            numberToEdges.put(number, edges1);
        }

        public int shortestPath(int node1, int node2) {
            final PriorityQueue<Step> queue = new PriorityQueue<>();
            used = new boolean[size];
            if (node1 == node2) {
                return 0;
            }
            queue.add(new Step(node1, 0));
            int result = Integer.MAX_VALUE;
            while (queue.size() != 0) {
                final Step step = queue.remove();
                if (used[step.getEdge()]) {
                    continue;
                }
                used[step.getEdge()] = true;
                if (step.getEdge() == node2) {
                    return step.getCurrentCoast();
                }
                final List<Edge> edges = numberToEdges.get(step.getEdge());
                if (edges == null) {
                    continue;
                }
                final int currentCoast = step.getCurrentCoast();
                for (Edge edge : edges) {
                    if (currentCoast + edge.getCoast() >= result) {
                        continue;
                    }
                    queue.add(new Step(edge.getNextEdge(), edge.getCoast() + currentCoast));
                }
            }
            return -1;
        }
    }

    class Step implements Comparable<Step> {
        private int edge;
        private int currentCoast;

        public Step(int edge, int currentCoast) {
            this.edge = edge;
            this.currentCoast = currentCoast;
        }

        public int getCurrentCoast() {
            return currentCoast;
        }

        public int getEdge() {
            return edge;
        }

        @Override
        public int compareTo(Step o) {
            return this.getCurrentCoast() - o.getCurrentCoast();
        }

        @Override
        public String toString() {
            return "Step{" +
                    "edge=" + edge +
                    ", currentCoast=" + currentCoast +
                    '}';
        }
    }

    class Edge {
        private int nextEdge;
        private int coast;

        public Edge(int nextEdge, int coast) {
            this.nextEdge = nextEdge;
            this.coast = coast;
        }

        public int getNextEdge() {
            return nextEdge;
        }

        public int getCoast() {
            return coast;
        }
    }