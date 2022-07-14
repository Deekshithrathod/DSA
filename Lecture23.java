import java.util.Scanner;

public class Lecture23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // maxTillI(arr, n);
        // eachSubArraySum(arr, n);
        System.out.println(longestArithSubArray(arr, n));

        sc.close();
    }

    // 1. MaxTill I
    public static void maxTillI(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            System.out.print(max + " ");

        }
    }

    // 2. Each Sub Array Sum
    public static void eachSubArraySum(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                // for (int k = i; k <= j; k++) {
                sum += arr[j];
                // }
                System.out.print(sum + " ");
            }
        }
    }

    // 3. Longest Arithmetic Subarray
    public static int longestArithSubArray(int arr[], int n) {
        if (n <= 2) {
            return n;
        }
        int currDiff = 0, prevDiff = arr[1] - arr[0], currLen = 2, maxLen = Integer.MIN_VALUE;

        for (int i = 2; i < n; i++) {
            currDiff = arr[i] - arr[i - 1];
            if (currDiff != prevDiff) {
                currLen = 0;
            }
            currLen++;
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    // 4. Record breaking day: Felt way too simple so didn't write the code.

}
