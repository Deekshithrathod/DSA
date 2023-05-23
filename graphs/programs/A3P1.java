import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A3P1 {
  static class Edge {
    int src;
    int dest;
    int wt;

    Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  // static class Pair implements Comparable<Pair> {
  static class Pair {
    int node;
    int price;
    int k;

    Pair(int node, int price, int k) {
      this.node = node;
      this.price = price;
      this.k = k;
    }

    // @Override
    // public int compareTo(Pair p) {
    // return this.dist - p.dist;
    // }
  }

  static ArrayList<Edge> graph[] = new ArrayList[5];

  static void createGraph() {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 100));
    // graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 2, 100));
    graph[1].add(new Edge(1, 3, 600));

    graph[2].add(new Edge(2, 0, 100));
    graph[2].add(new Edge(2, 3, 200));

    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));
  }

  public static void main(String[] args) {
    // Cheapest Flights within K Stops
    createGraph();
    System.out.println(findCheapestPrice(graph, 0, 3, 1));
  }

  // static int findCheapestPrice(ArrayList<Edge> graph[], int src, int dest) {
  // // int answer = 0;

  // int prices[] = new int[graph.length];

  // Arrays.fill(prices, Integer.MAX_VALUE);
  // prices[src] = 0;

  // for (int i = 0; i < graph.length - 1; i++) {
  // for (int j = 0; j < graph.length; j++) {
  // for (Edge edge : graph[j]) {

  // int u = edge.src;
  // int v = edge.dest;
  // int price = edge.wt;

  // if (prices[u] != Integer.MAX_VALUE && prices[u] + price < prices[v]) {
  // prices[v] = price + prices[u];
  // }
  // }
  // }
  // }

  // return prices[dest];
  // }
  static int findCheapestPrice(ArrayList<Edge> graph[], int src, int dest, int K) {
    int prices[] = new int[graph.length];
    Arrays.fill(prices, Integer.MAX_VALUE);
    prices[src] = 0;

    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(src, 0, 0));

    while (!queue.isEmpty()) {
      Pair curr = queue.poll();
      if (curr.k > K)
        continue;
      for (Edge edge : graph[curr.node]) {
        // int u = edge.src;
        int v = edge.dest;
        int price = edge.wt;

        if (curr.price + price < prices[v] && curr.k <= K) {
          prices[v] = price + curr.price;
          queue.add(new Pair(v, prices[v], curr.k + 1));
        }
      }
    }

    if (prices[dest] == Integer.MAX_VALUE) {
      return -1;
    }
    return prices[dest];
  }
}
