import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Program1
 */

class Edge {
  int src;
  int dest;

  Edge(int src, int dest) {
    this.src = src;
    this.dest = dest;
  }
}

public class Program1 {
  static ArrayList<Edge> graphConnected[] = new ArrayList[5];;
  static ArrayList<Edge> graphDisConnected[] = new ArrayList[8];;

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

  static void createGraphDisconnected() {
    for (int i = 0; i < graphDisConnected.length; i++) {
      graphDisConnected[i] = new ArrayList<>();
    }

    graphDisConnected[0].add(new Edge(0, 1));

    graphDisConnected[1].add(new Edge(1, 0));
    graphDisConnected[1].add(new Edge(1, 2));
    graphDisConnected[1].add(new Edge(1, 3));

    graphDisConnected[2].add(new Edge(2, 1));
    graphDisConnected[2].add(new Edge(2, 3));
    graphDisConnected[2].add(new Edge(2, 4));

    graphDisConnected[3].add(new Edge(3, 1));
    graphDisConnected[3].add(new Edge(3, 2));

    graphDisConnected[4].add(new Edge(4, 2));

    graphDisConnected[5].add(new Edge(5, 6));
    graphDisConnected[5].add(new Edge(5, 7));

    graphDisConnected[6].add(new Edge(6, 5));
    graphDisConnected[6].add(new Edge(6, 7));

    graphDisConnected[7].add(new Edge(7, 5));
    graphDisConnected[7].add(new Edge(7, 6));

  }

  public static void main(String[] args) {
    // System.out.println("BFS");
    // createGraphConnected();
    // boolean visited[] = new boolean[graphConnected.length];
    // for (int i = 0; i < visited.length; i++) {
    // visited[i] = false;
    // }
    // bfs(0, visited, true);

    // createGraphDisconnected();
    // boolean visited[] = new boolean[graphDisConnected.length];
    // for (int i = 0; i < visited.length; i++) {
    // visited[i] = false;
    // }

    // for (int i = 0; i < visited.length; i++) {
    // if (!visited[i]) {
    // bfs(i, visited, false);
    // }
    // }

    // System.out.println("DFS");
    // createGraphConnected();
    // boolean visited[] = new boolean[graphConnected.length];
    // dfs(0, visited);

    // createGraphDisconnected();
    // boolean visited[] = new boolean[graphDisConnected.length];

    // for (int i = 0; i < visited.length; i++) {
    // if (!visited[i]) {
    // dfs(i, visited, false);
    // }
    // }

    // All paths
    createGraphConnected();

    boolean visited[] = new boolean[graphConnected.length];
    for (int i = 0; i < visited.length; i++) {
      visited[i] = false;
    }

    allPaths(0, "", visited, 4);
  }

  static void bfs(int start, boolean visited[], boolean isConnected) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int currVertex = queue.poll();
      System.out.println(currVertex);

      ArrayList<Edge> children = isConnected ? graphConnected[currVertex] : graphDisConnected[currVertex];

      for (Edge child : children) {
        if (!visited[child.dest]) {
          visited[child.dest] = true;
          queue.add(child.dest);
        }
      }
    }

  }

  static void dfs(int start, boolean visited[], boolean isConnected) {
    Stack<Integer> st = new Stack<>();

    st.push(start);
    visited[start] = true;

    while (!st.isEmpty()) {
      int currVertex = st.pop();
      System.out.println(currVertex);

      ArrayList<Edge> children = isConnected ? graphConnected[currVertex] : graphDisConnected[currVertex];
      for (Edge child : children) {
        if (!visited[child.dest]) {
          visited[child.dest] = true;
          st.push(child.dest);
        }
      }
    }
  }

  static void allPaths(int curr, String currPath, boolean visited[], int target) {
    if (curr == target) {
      System.out.println(currPath + curr);
      return;
    }

    ArrayList<Edge> children = graphConnected[curr];
    visited[curr] = true;

    for (Edge edge : children) {
      if (!visited[edge.dest]) {
        allPaths(edge.dest, currPath + curr + "-", visited, target);
      }
    }
    visited[curr] = false;
  }
}