import java.util.Scanner;

public class Lecture37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(findNumsDivByAorB(a, b, n));
        System.out.println(findGCD(a, b));
        sc.close();
    }

    public static int findNumsDivByAorB(int a, int b, int n) {
        // Inclusion-Exclusion Principle
        return (n / a) + (n / b) - (n / (a * b));
    }

    public static int findGCD(int a, int b) {
        // int result = 0;
        if (b > a) {
            int temp = b;
            b = a;
            a = temp;
        }
        int c = 1;
        while (c != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
