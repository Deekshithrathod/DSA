import java.util.ArrayList;
import java.util.Stack;

// import P1A1.Pair;
public class Program2 {
  static class Edge {
    int src;
    int dest;

    Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  static ArrayList<Edge> graphConnected[] = new ArrayList[5];
  static ArrayList<Edge> graphDA[] = new ArrayList[5];
  static ArrayList<Edge> graphDC[] = new ArrayList[5];
  static ArrayList<Edge> topoGraph[] = new ArrayList[6];

  static void createGraphConnected() {
    // graphConnected = new ArrayList<>[5];
    for (int i = 0; i < graphConnected.length; i++) {
      graphConnected[i] = new ArrayList<>();
    }
    graphConnected[0].add(new Edge(0, 1));

    graphConnected[1].add(new Edge(1, 0));
    graphConnected[1].add(new Edge(1, 2));
    graphConnected[1].add(new Edge(1, 3));

    graphConnected[2].add(new Edge(2, 1));
    graphConnected[2].add(new Edge(2, 3));
    graphConnected[2].add(new Edge(2, 4));

    graphConnected[3].add(new Edge(3, 1));
    graphConnected[3].add(new Edge(3, 2));

    graphConnected[4].add(new Edge(4, 2));
  }

  static void createDAG() {
    // graphConnected = new ArrayList<>[5];
    for (int i = 0; i < graphDA.length; i++) {
      graphDA[i] = new ArrayList<>();
    }
    graphDA[0].add(new Edge(0, 1));

    // graphDA[1].add(new Edge(1, 0));
    graphDA[1].add(new Edge(1, 2));
    graphDA[1].add(new Edge(1, 3));

    // graphDA[2].add(new Edge(2, 1));
    // graphDA[2].add(new Edge(2, 3));
    graphDA[2].add(new Edge(2, 4));

    // graphDA[3].add(new Edge(3, 1));
    // graphDA[3].add(new Edge(3, 2));
    graphDA[3].add(new Edge(3, 4));

    // graphDA[4].add(new Edge(4, 2));
  }

  static void createTopoGraph() {
    for (int i = 0; i < topoGraph.length; i++) {
      topoGraph[i] = new ArrayList<>();
    }

    topoGraph[2].add(new Edge(2, 3));

    topoGraph[3].add(new Edge(3, 1));

    topoGraph[4].add(new Edge(4, 0));
    topoGraph[4].add(new Edge(4, 1));

    topoGraph[5].add(new Edge(5, 2));
    topoGraph[5].add(new Edge(5, 0));

  }

  static void createDCG() {
    // graphConnected = new ArrayList<>[5];
    for (int i = 0; i < graphDC.length; i++) {
      graphDC[i] = new ArrayList<>();
    }
    graphDC[0].add(new Edge(0, 1));

    // graphDC[1].add(new Edge(1, 0));
    graphDC[1].add(new Edge(1, 2));
    // graphDC[1].add(new Edge(1, 3));

    // graphDC[2].add(new Edge(2, 1));
    graphDC[2].add(new Edge(2, 3));
    graphDC[2].add(new Edge(2, 4));

    graphDC[3].add(new Edge(3, 1));
    // graphDC[3].add(new Edge(3, 2));

    // graphDC[4].add(new Edge(4, 2));
  }

  public static void main(String[] args) {
    // cycle in un-directed
    // createGraphConnected();
    // System.out.println(isCyclePresentUD(graphConnected, new
    // boolean[graphConnected.length], 0, -1));

    // cycle in directed

    // DAG
    // createDAG();
    // System.out.println(isCyclePresentD(graphDA, new boolean[graphDA.length], new
    // boolean[graphDA.length], 0));

    // DCG
    // createDCG();
    // System.out.println(isCyclePresentD(graphDC, new boolean[graphDC.length], new
    // boolean[graphDC.length], 0));

    // Topological Sort
    createTopoGraph();
    topologicalSort(topoGraph);

  }

  static boolean isCyclePresentUD(ArrayList<Edge> graph[], boolean visited[], int curr, int parent) {
    visited[curr] = true;

    for (Edge edge : graph[curr]) {
      if (edge.dest != parent && visited[edge.dest]) {
        return true;
      } else if (!visited[edge.dest]) {
        if (isCyclePresentUD(graph, visited, edge.dest, curr)) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean isCyclePresentD(ArrayList<Edge> graph[], boolean visited[], boolean recur[], int curr) {
    visited[curr] = true;
    recur[curr] = true;

    for (Edge edge : graph[curr]) {
      if (recur[edge.dest]) {
        return true;
      } else if (!visited[edge.dest]) {
        isCyclePresentD(graph, visited, recur, edge.dest);
      }
    }

    recur[curr] = false;
    return false;
  }

  static void topologicalUtil(ArrayList<Edge> graph[], boolean visited[], int curr, Stack<Integer> st) {
    visited[curr] = true;

    // dfs
    for (Edge edge : graph[curr]) {
      if (!visited[edge.dest]) {
        topologicalUtil(graph, visited, edge.dest, st);
      }
    }

    st.push(curr);
  }

  static void topologicalSort(ArrayList<Edge> graph[]) {

    boolean visited[] = new boolean[graph.length];
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < visited.length; i++) {
      if (!visited[i]) {
        topologicalUtil(graph, visited, i, st);
      }
    }

    while (!st.empty()) {
      System.out.println(st.pop());
    }

  }
}
