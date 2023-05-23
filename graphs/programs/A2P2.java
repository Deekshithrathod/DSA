import java.util.ArrayList;

public class A2P2 {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  static ArrayList<Edge> graphDA[] = new ArrayList[7];

  static void createDAG() {
    for (int i = 0; i < graphDA.length; i++) {
      graphDA[i] = new ArrayList<>();
    }
    graphDA[0].add(new Edge(0, 1));
    graphDA[0].add(new Edge(0, 2));

    graphDA[1].add(new Edge(1, 2));
    graphDA[1].add(new Edge(1, 3));

    graphDA[2].add(new Edge(2, 5));

    graphDA[3].add(new Edge(3, 0));

    // graphDA[4].add(new Edge(4, 2));
    graphDA[4].add(new Edge(4, 5));

    // graphDA[5].add(new Edge(5, 4));
  }

  public static void main(String[] args) {
    createDAG();
    for (int i : findSafeNodes(graphDA)) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  // find all safe nodes. A node is a safe node if every possible path starting
  // from that node leads to a terminal node (or another safe node).
  static ArrayList<Integer> findSafeNodes(ArrayList<Edge> graph[]) {
    ArrayList<Integer> result = new ArrayList<>();
    boolean visited[] = new boolean[graph.length];
    boolean recur[] = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        hasCycle(graph, visited, recur, i);
      }
    }

    for (int i = 0; i < visited.length; i++) {
      if (visited[i] && !recur[i]) {
        result.add(i);
      }
    }

    return result;
  }

  static boolean hasCycle(ArrayList<Edge> graph[], boolean visited[], boolean recur[], int curr) {
    visited[curr] = true;
    recur[curr] = true;

    for (Edge edge : graph[curr]) {
      if (recur[edge.dest]) {
        return true;
      }
      if (!visited[edge.dest]) {
        if (hasCycle(graph, visited, recur, edge.dest)) {
          return true;
        }
      }
    }

    recur[curr] = false;
    return false;
  }
}
