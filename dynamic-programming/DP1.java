import java.util.HashMap;

// Recursion
// Memoization : Top Down
// Tabulation : Bottom Up
// Space optimization
// System.out.println(fiboRecur(n));

/**
 * dp-1
 */
public class DP1 {
  public static void main(String[] args) {
    // fibonacci
    int n = 40;

    // Recursion

    // Memoization : Top Down
    System.out.println(fiboMemo(n, new HashMap<>()));

    // Tabulation : Bottom Up
    // System.out.println(fiboTable(n));

    // Space optimization
    // System.out.println(fiboOptimized(n));
  }

  static int fiboRecur(int n) {
    if (n <= 1) {
      return n;
    }
    return fiboRecur(n - 1) + fiboRecur(n - 2);
  }

  static int fiboMemo(int n, HashMap<Integer, Integer> hm) {
    if (n <= 1) {
      return n;
    }
    if (hm.containsKey(n)) {
      return hm.get(n);
    }

    int result = fiboMemo(n - 1, hm) + fiboMemo(n - 2, hm);
    hm.put(n, result);
    return hm.get(n);
  }

  static int fiboTable(int n) {
    if (n < 2) {
      return n;
    }

    int dp[] = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }

  static int fiboOptimized(int n) {
    if (n < 2) {
      return n;
    }

    int prev1 = 1;
    int prev2 = 0;
    int answer = 0;

    while (n > 1) {
      answer = prev1 + prev2;

      prev2 = prev1;
      prev1 = answer;

      n--;
    }

    return answer;
  }
}