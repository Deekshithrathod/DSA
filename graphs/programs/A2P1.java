import java.util.ArrayList;

public class A2P1 {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  static ArrayList<Edge> graphDA[] = new ArrayList[4];

  static void createDAG() {
    for (int i = 0; i < graphDA.length; i++) {
      graphDA[i] = new ArrayList<>();
    }
    // graphDA[0].add(new Edge(0, 1));

    graphDA[1].add(new Edge(1, 0));

    graphDA[2].add(new Edge(2, 1));

    graphDA[3].add(new Edge(3, 2));
  }

  public static void main(String[] args) {
    createDAG();
    System.out.println(!hasCycle(graphDA, 0, new boolean[graphDA.length], new boolean[graphDA.length]));
  }

  // Course Schedule : Check if all courses can be done
  // basically check if there's a cycle in the DAG

  static boolean hasCycle(ArrayList<Edge> graph[], int curr, boolean visited[], boolean recur[]) {
    visited[curr] = true;
    recur[curr] = true;

    for (Edge edge : graph[curr]) {
      if (recur[edge.dest]) {
        return true;
      }
      if (!visited[edge.dest]) {
        if (hasCycle(graph, edge.dest, visited, recur)) {
          return true;
        }
      }
    }

    recur[curr] = false;
    return false;
  }

}
