import java.io.*;
import java.util.*;

public class Vanilla {
    public static class Node implements Comparable<Node> {
        int id;
        List<Edge> neighbors;
        double cost;
        boolean visited;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
            this.cost = Long.MAX_VALUE;
            this.visited = false;
        }

        public int compareTo(Node other) {
            return Double.compare(this.cost, other.cost);
        }
    }

    public static class Edge {
        Node dest;
        double weight;

        public Edge(Node dest, double weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<Node> graph, Node source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        source.cost = 0;
        source.visited = true;
        pq.add(source);

        while (!pq.isEmpty()) {
            Node current = pq.remove();
            current.visited = true;
            for (Edge edge : current.neighbors) {
                Node nextNode = edge.dest;
                double newCost = current.cost + edge.weight;
                
                if (!nextNode.visited && newCost < nextNode.cost) {
                    nextNode.cost = newCost;             
                    pq.add(nextNode);
                }               
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final Scanner scan = new Scanner(System.in);
        final int numCases = scan.nextInt();
        
        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            // Read in input
            final int n = scan.nextInt();
            final int numEdges = scan.nextInt();

            final List<Node> graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new Node(i));
            }

            for (int i = 0; i < numEdges; i++) {
                // Convert to 0 indexing
                final int start = scan.nextInt() - 1;
                final int end = scan.nextInt() - 1;
                final int speed = scan.nextInt();
                final int dist = scan.nextInt();
                final double weight = dist * 1.0 / speed;
                final Node nodeStart = graph.get(start);
                final Node nodeEnd = graph.get(end);

                nodeStart.neighbors.add(new Edge(nodeEnd, weight));
            }

            
            // All of the costs will be saved in the node objects
            dijkstra(graph, graph.get(0));
            

            double ans = graph.get(n-1).cost;
            if (ans == Long.MAX_VALUE) {
                System.out.println("NO");
            } else {
                System.out.println((ans));
            }
        }
        scan.close();
    }
}
