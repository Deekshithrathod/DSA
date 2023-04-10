import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Graphs
 */
public class Graphs {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  static void createGraph(ArrayList<Edge>[] graph) {
    // ArrayList<Edge>[] graph = new ArrayList[n];
    // graph = new ArrayList[n];
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
    graph[3].add(new Edge(3, 5));

    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
    graph[4].add(new Edge(4, 5));

    graph[5].add(new Edge(5, 3));
    graph[5].add(new Edge(5, 4));
    graph[5].add(new Edge(5, 6));

    graph[6].add(new Edge(6, 5));

    // return graph;
  }

  public static void main(String[] args) {
    int n = 7;
    ArrayList<Edge>[] graph = new ArrayList[n];
    createGraph(graph);

    boolean visited[] = new boolean[n];
    // dfs(graph, visited, 0);
    allPaths(graph, visited, 5, "", 1);
  }

  public static void bfs(ArrayList<Edge> graph[], boolean visited[], int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      System.out.println(curr);

      for (Edge edge : graph[curr]) {
        if (!visited[edge.dest]) {
          visited[edge.dest] = true;
          queue.add(edge.dest);
        }
      }
    }
  }

  public static void dfs(ArrayList<Edge> graph[], boolean visited[], int curr) {
    visited[curr] = true;
    System.out.println(curr);

    for (Edge edge : graph[curr]) {
      if (!visited[edge.dest]) {
        dfs(graph, visited, edge.dest);
      }
    }
  }

  public static void allPaths(ArrayList<Edge> graph[], boolean visited[], int target, String path, int curr) {
    visited[curr] = true;
    // System.out.println(curr);
    if (curr == target) {
      System.out.println(path + "-" + curr);
      // return;
    }

    for (Edge edge : graph[curr]) {
      if (!visited[edge.dest]) {
        allPaths(graph, visited, target, path + "-" + curr, edge.dest);
      }
    }
    visited[curr] = false;
  }
}
