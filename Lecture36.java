import java.util.Scanner;

public class Lecture36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // int arr[] = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }
        // primesTillN(n);
        primeFactorisation(n);
        sc.close();
    }

    public static void primesTillN(int n) {
        boolean arr[] = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (arr[i] == true) {
                continue;
            }
            for (int j = i * i; j <= n; j += i) {
                arr[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                System.out.println(i);
            }
        }

    }

    public static void primeFactorisation(int n) {
        int arr[] = new int[n + 1];
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                continue;
            }
            arr[i] = i;
            // if(arr[i] != 0){
            for (int j = i * i; j <= n; j += i) {
                if (arr[j] == 0) {
                    arr[j] = i;
                }
            }
            // }
        }
        // for (int i = 0; i <= n; i++) {
        // System.out.println(i + "->" + arr[i]);
        // }
        while (n != 1) {
            System.out.println(arr[n]);
            n = n / arr[n];
        }
    }
}
