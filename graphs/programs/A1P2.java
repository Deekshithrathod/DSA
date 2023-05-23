import java.util.Scanner;

// Number of Islands
public class A1P2 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int m = s.nextInt();
    int n = s.nextInt();

    int arr[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = s.nextInt();
      }
    }
    System.out.println(findIslands(arr));

    s.close();
  }

  static int findIslands(int graph[][]) {
    int count = 0;
    int m = graph.length;
    int n = graph[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1) {
          count++;
          runDFS(graph, i, j, m, n);
        }
      }
    }

    return count;
  }

  static void runDFS(int graph[][], int i, int j, int m, int n) {
    if (isSafe(i, j, m, n) && graph[i][j] == 1) {
      graph[i][j] = 0;

      runDFS(graph, i + 1, j, m, n);
      runDFS(graph, i - 1, j, m, n);
      runDFS(graph, i, j + 1, m, n);
      runDFS(graph, i, j - 1, m, n);
    }

  }

  static boolean isSafe(int i, int j, int m, int n) {
    return i >= 0 && j >= 0 && i < m && j < n;
  }
}
