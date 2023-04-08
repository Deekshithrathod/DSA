import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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

  static ArrayList<Edge>[] createGraph(int v) {

    // Simple Graph
    // ArrayList<Edge> graph[] = new ArrayList[4];

    // for (int i = 0; i < 4; i++) {
    // graph[i] = new ArrayList<Edge>();
    // }

    // graph[0].add(new Edge(0, 2));

    // graph[1].add(new Edge(1, 2));
    // graph[1].add(new Edge(1, 3));

    // graph[2].add(new Edge(2, 0));
    // graph[2].add(new Edge(2, 1));
    // graph[2].add(new Edge(2, 3));

    // Complecated Graph
    ArrayList<Edge> graph[] = new ArrayList[v];

    for (int i = 0; i < v; i++) {
      graph[i] = new ArrayList<Edge>();
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

    return graph;
  }

  static void breadthFirstSearch(ArrayList<Edge> graph[]) {
    Queue<Integer> queue = new ArrayDeque<>();
    boolean visited[] = new boolean[4];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }

    queue.add(0);

    while (!queue.isEmpty()) {
      int currNodeval = queue.poll();

      if (!visited[currNodeval]) {
        visited[currNodeval] = true;
        System.out.println(currNodeval);
        for (Edge edge : graph[currNodeval]) {
          if (!visited[edge.dest]) {
            queue.add(edge.dest);
          }
        }
      }

    }
  }

  static void depthFirstSearch(ArrayList<Edge> graph[]) {
    Stack<Integer> stack = new Stack<>();

    stack.add(0);
    boolean visited[] = new boolean[graph.length];

    while (!stack.isEmpty()) {
      int currNodeval = stack.pop();

      if (!visited[currNodeval]) {
        visited[currNodeval] = true;
        System.out.println(currNodeval);

        for (Edge edge : graph[currNodeval]) {
          stack.add(edge.dest);

        }
      }
    }
  }

  static void dfsWithCallStack(ArrayList<Edge> graph[], boolean visited[], int curr) {
    System.out.println(curr);
    visited[curr] = true;

    for (Edge edge : graph[curr]) {
      if (visited[edge.dest] == false) {
        dfsWithCallStack(graph, visited, edge.dest);
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<Edge> graph[] = createGraph(7);
    // breadthFirstSearch(graph);
    // depthFirstSearch(graph);
    boolean vis[] = new boolean[7];
    for (int i = 0; i < vis.length; i++) {
      vis[i] = false;
    }
    dfsWithCallStack(graph, vis, 0);
  }
}