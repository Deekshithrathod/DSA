import java.util.Scanner;

public class Lecture38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.close();
        System.out.println(addTillN(n));
        System.out.println(raisedToP(n, p));
        System.out.println(factorial(n));
        System.out.println(fibonacci(n));
    }

    public static int addTillN(int n) {
        if (n == 0) {
            return 0;
        }
        return n + addTillN(n - 1);
    }

    public static int raisedToP(int n, int p) {
        if (p == 0) {
            return 1;
        }
        return n * raisedToP(n, p - 1);
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
