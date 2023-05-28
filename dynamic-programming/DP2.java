import java.util.HashMap;

public class DP2 {
  public static void main(String[] args) {
    // climbing stairs

    // Recursion
    // Memoization : Top Down
    // Tabulation : Bottom Up
    // Space optimization
    // System.out.println(fiboRecur(n));

  }

  static int stairRecur(int n) {
    if (n <= 1) {
      return n;
    }

    return stairRecur(n - 1) + stairRecur(n - 2);
  }

  static int stairMemo(int n, HashMap<Integer, Integer> hm) {
    if (n <= 1) {
      hm.put(n, n);
      return hm.get(n);
    }

    if (hm.containsKey(n)) {
      return hm.get(n);
    }

    int result = stairMemo(n - 1, hm) + stairMemo(n - 2, hm);
    hm.put(n, result);
    return hm.get(result);
  }

  static int stairTabulation(int n) {
    int dp[] = new int[n];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {

    }
  }

}
