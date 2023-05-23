import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Rot Oranges
public class A1P1 {
  static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  public static void main(String[] args) {
    // take the input
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();

    int arr[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }
    System.out.println(rot(arr));

    s.close();
  }

  static int rot(int graph[][]) {
    // find all the places where two is present
    Queue<Pair> queue = new LinkedList<>();

    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        if (graph[i][j] == 2) {
          queue.add(new Pair(i, j));
        }
      }
    }

    // adding delimiter
    queue.add(new Pair(-1, -1));

    // send it to dfs
    int count = startRotting(graph, queue);
    // verify to
    return isNotCompletelyRot(graph) ? -1 : count;
  }

  static boolean isNotCompletelyRot(int graph[][]) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        if (graph[i][j] == 1) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean isDelimiter(Pair p) {
    return p.i == -1 && p.j == -1;
  }

  static int startRotting(int graph[][], Queue<Pair> queue) {
    int count = 0;
    while (!queue.isEmpty()) {
      boolean atLeastOneRot = false;

      while (!isDelimiter(queue.peek())) {
        Pair currPair = queue.poll();
        int i = currPair.i;
        int j = currPair.j;

        if (rotOneSide(i + 1, j, graph, queue)) {
          atLeastOneRot = true;
        }
        if (rotOneSide(i - 1, j, graph, queue)) {
          atLeastOneRot = true;
        }
        if (rotOneSide(i, j + 1, graph, queue)) {
          atLeastOneRot = true;
        }
        if (rotOneSide(i, j - 1, graph, queue)) {
          atLeastOneRot = true;
        }
      }
      queue.poll();

      if (atLeastOneRot) {
        queue.add(new Pair(-1, -1));
        count++;
      }
    }
    return count;
  }

  static boolean isSafe(int i, int j, int m, int n) {
    return i >= 0 && j >= 0 && i < m && j < n;
  }

  static boolean rotOneSide(int i, int j, int graph[][], Queue<Pair> queue) {
    if (isSafe(i, j, graph.length, graph[0].length)) {
      if (graph[i][j] == 1) {
        graph[i][j] = 2;
        queue.add(new Pair(i, j));
        return true;
      }
    }
    return false;
  }
}
