import java.util.Scanner;

public class Lecture39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // System.out.println(isArraySorted(arr, 0));
        printTillNDec(n);
        printTillNInc(n);
        scanner.close();

    }

    public static boolean isArraySorted(int arr[], int i) {
        if (arr.length == 0 || i == arr.length - 1) {
            return true;
        }
        return isArraySorted(arr, i + 1) && arr[i] < arr[i + 1];
    }

    public static void printTillNInc(int n) {
        if (n == 0) {
            return;
        }
        printTillNInc(n - 1);
        System.out.println(n);
    }

    public static void printTillNDec(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printTillNDec(n - 1);
    }
}
