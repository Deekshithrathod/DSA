import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Program3 {
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

  static class Pair implements Comparable<Pair> {
    int node;
    int dist;

    Pair(int node, int dist) {
      this.node = node;
      this.dist = dist;
    }

    @Override
    public int compareTo(Pair p) {
      return this.dist - p.dist;
    }
  }

  static ArrayList<Edge> graph[] = new ArrayList[6];
  static ArrayList<Edge> graphBellMan[] = new ArrayList[5];

  static void createGraph() {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 2, 1));
    graph[1].add(new Edge(1, 3, 7));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));
  }

  static void createGraphBellMan() {
    for (int i = 0; i < graphBellMan.length; i++) {
      graphBellMan[i] = new ArrayList<>();
    }
    graphBellMan[0].add(new Edge(0, 1, 2));
    graphBellMan[0].add(new Edge(0, 2, 4));

    graphBellMan[1].add(new Edge(1, 2, -4));

    graphBellMan[2].add(new Edge(2, 3, 2));

    graphBellMan[3].add(new Edge(3, 4, 4));

    graphBellMan[4].add(new Edge(4, 1, -10));
  }

  public static void main(String[] args) {
    // createGraph();
    // dijkstra(graph, 0, 4);

    createGraphBellMan();
    bellmanFords(graphBellMan, 0, graphBellMan.length);
  }

  static void dijkstra(ArrayList<Edge> graph[], int start, int target) {
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean visited[] = new boolean[graph.length];
    Arrays.fill(visited, false);

    int distArr[] = new int[graph.length];

    Arrays.fill(distArr, Integer.MAX_VALUE);
    distArr[start] = 0;

    pq.add(new Pair(start, distArr[start]));

    while (!pq.isEmpty()) {
      Pair currPair = pq.poll();
      if (!visited[currPair.node]) {
        visited[currPair.node] = true;

        for (Edge adj : graph[currPair.node]) {
          int u = adj.src;
          int v = adj.dest;
          int wt = adj.wt;
          if (distArr[u] + wt < distArr[v]) {
            distArr[v] = distArr[u] + wt;
            pq.add(new Pair(v, distArr[v]));
          }
        }
      }
    }

    System.out.println("Distance from " + start + " -> " + target + " : " + distArr[target]);
  }

  static void bellmanFords(ArrayList<Edge> graph[], int start, int V) {
    int dist[] = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    for (int i = 0; i < V - 1; i++) {
      for (int j = 0; j < V; j++) {
        for (Edge e : graph[j]) {
          int u = e.src;
          int v = e.dest;
          int wt = e.wt;

          if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
          }
        }
      }
    }

    for (int j = 0; j < graph.length; j++) {
      for (Edge e : graph[j]) {
        int u = e.src;
        int v = e.dest;
        int wt = e.wt;

        if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
          // dist[v] = dist[u] + wt;
          System.out.println("Has a -ve cycle");
          return;
        }
      }
    }

    for (int a : dist) {
      System.out.print(a + " ");
    }
    System.out.println();

  }
}