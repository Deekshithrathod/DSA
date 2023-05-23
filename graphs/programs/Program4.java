import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Program4 {
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
    int cost;

    Pair(int node, int cost) {
      this.node = node;
      this.cost = cost;
    }

    @Override
    public int compareTo(Pair p) {
      return this.cost - p.cost;
    }
  }

  static ArrayList<Edge> graph[] = new ArrayList[5];

  static void createGraph() {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    // graph[0].add(new Edge(0, 1, 10));
    // graph[0].add(new Edge(0, 2, 15));
    // graph[0].add(new Edge(0, 3, 30));

    // graph[1].add(new Edge(1, 0, 10));
    // graph[1].add(new Edge(1, 3, 40));

    // graph[2].add(new Edge(2, 0, 15));
    // graph[2].add(new Edge(2, 3, 30));

    // graph[3].add(new Edge(3, 1, 40));
    // graph[3].add(new Edge(3, 2, 50));

    graph[0].add(new Edge(0, 2, 0));
    graph[0].add(new Edge(0, 3, 0));

    graph[1].add(new Edge(1, 0, 0));

    graph[2].add(new Edge(2, 1, 0));

    graph[3].add(new Edge(3, 4, 0));

  }

  public static void main(String[] args) {
    createGraph();
    // primsAlgorithm(graph, 0);
    // printAllEdgess
    kosarajuAlgorithm(graph, 0);
  }

  static void primsAlgorithm(ArrayList<Edge> graph[], int start) {

    PriorityQueue<Pair> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[graph.length];
    int cost = 0;

    pq.add(new Pair(start, 0));

    while (!pq.isEmpty()) {
      Pair currPair = pq.poll();

      if (!vis[currPair.node]) {
        vis[currPair.node] = true;
        cost += currPair.cost;

        for (Edge e : graph[currPair.node]) {
          if (!vis[e.dest]) {
            pq.add(new Pair(e.dest, e.wt));
          }
        }
      }

    }
    System.out.println(cost);
  }

  static void topoSort(ArrayList<Edge> graph[], int curr, Stack<Integer> st, boolean vis[]) {
    vis[curr] = true;
    for (Edge e : graph[curr]) {
      if (!vis[e.dest]) {
        topoSort(graph, e.dest, st, vis);
      }
    }
    st.push(curr);
  }

  static void kosarajuAlgorithm(ArrayList<Edge> graph[], int src) {
    // step-1 : Topo Sort Stack
    Stack<Integer> st = new Stack<>();
    boolean vis[] = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!vis[i]) {
        topoSort(graph, i, st, vis);
      }
    }

    // step-2 : Transpose the Graph
    ArrayList<Edge> transpose[] = new ArrayList[graph.length];
    for (int i = 0; i < transpose.length; i++) {
      vis[i] = false;
      transpose[i] = new ArrayList<Edge>();
    }

    for (int i = 0; i < graph.length; i++) {
      for (Edge e : graph[i]) {
        transpose[e.dest].add(new Edge(e.dest, e.src, e.wt));
      }
    }

    // step-3 : Run DFS on the transpose graph
    while (!st.empty()) {
      int currNode = st.pop();

      if (!vis[currNode]) {
        dfs(transpose, currNode, vis);
        System.out.println();
      }
    }

  }

  static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
    vis[curr] = true;
    for (Edge e : graph[curr]) {
      if (!vis[e.dest]) {
        dfs(graph, e.dest, vis);
      }
    }
    System.out.print(curr + " ");
  }
}
