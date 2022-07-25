public class Lecture42 {
    public static void main(String[] args) {
        // int n = 4;
        // int m = 2;
        // 2x10 tiles & 2*1 tiles
        int weights[] = { 10, 20, 30 };
        int prices[] = { 100, 50, 150 };
        // int answer[][] = new int[weights.length][weights.length];
        System.out.println(knapSack(0, weights, prices, 50));
        // System.out.println(countWays(n, m));
    }

    public static int countWays(int n, int m) {
        if (n == 0) {
            return 0;
        }
        // if (n == m) {
        // return 2;
        // }
        if (n == 1) {
            return 1;
        }

        return countWays(n - 1, m) + countWays(n - m, m);
    }

    public static int friendsPairingProblem(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return friendsPairingProblem(n - 1) + ((n - 1) * friendsPairingProblem(n - 2));
    }

    // knapsack problem
    public static int knapSack(int i, int weights[], int prices[], int w) {
        if (w == 0 || i == weights.length) {
            return 0;
        }
        // two ways to do this
        // if(lessThanAvailableWiegth)
        // if()
        int p1 = 0;
        if (weights[i] < w) {
            p1 = prices[i] + knapSack(i + 1, weights, prices, w - weights[i]);
        }
        int p2 = knapSack(i + 1, weights, prices, w);
        return Math.max(p1, p2);
    }
}
