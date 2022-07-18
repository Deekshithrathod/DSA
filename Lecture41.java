import java.util.Scanner;

public class Lecture41 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // int n = s.nextInt();
        // String str = s.nextLine();
        // printPermutations(str, "");
        System.out.println(counthPaths(1, 1, 3, 3));
        s.close();

    }

    public static void printPermutations(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String restString = str.substring(0, i) + str.substring(i + 1);
            printPermutations(restString, result + currChar);
        }
    }

    public static int countPath(int s, int e) {
        if (s == e) {
            return 1;
        }
        if (s > e) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i < +6; i++) {
            count += countPath(s + i, e);
        }
        return count;
    }

    public static int counthPaths(int r, int c, int m, int n) {
        // count path, if you can move only right or bottom in the matrix from top left
        // to bottom right
        if (r == m && c == n) {
            return 1;
        }

        if (r > m || c > n) {
            return 0;
        }
        return counthPaths(r + 1, c, m, n) + counthPaths(r, c + 1, m, n);
    }
}
