import java.util.Scanner;

public class Lecture25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // printAllPossibleSubArrays(arr, n);
        // maxSubArraySum(arr, n);
        System.out.println(circularSub(arr, n));
        scanner.close();
    }

    // 1. Print all possible subarrays
    public static void printAllPossibleSubArrays(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    // 2. find maxSubarraySum
    public static void maxSubArraySum(int arr[], int n) {
        // Brute force approach = O(n^3)

        // Cummilative Sum Approach
        int cumSum[] = new int[n + 1];
        cumSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            cumSum[i] = cumSum[i - 1] + arr[i - 1];
        }

        int maxSubSum = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int currSum = cumSum[j] - cumSum[i];
                maxSubSum = Math.max(maxSubSum, currSum);
            }

        }

        // Kadane's algorithm
        int currSum = 0;
        int maxKadaSum = Integer.MIN_VALUE;
        for (int i : arr) {
            currSum += i;
            if (currSum < 0) {
                currSum = 0;
            }
            maxKadaSum = Math.max(maxKadaSum, currSum);
        }
        System.out.println(maxSubSum);
        System.out.println(maxKadaSum);
        // System.out.println(maxSubSum);
    }

    public static int kadaneSum(int arr[], int n) {
        int currSum = 0;
        int maxKadaSum = Integer.MIN_VALUE;
        for (int i : arr) {
            currSum += i;
            if (currSum < 0) {
                currSum = 0;
            }
            maxKadaSum = Math.max(maxKadaSum, currSum);
        }
        return maxKadaSum;
    }

    // 3. Circular Sub-array
    public static int circularSub(int arr[], int n) {
        // regularSum
        int regularSum = kadaneSum(arr, n);
        // inverseSum
        // int inverseSum = totalSum + revKadane;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
            arr[i] = (-1 * arr[i]);
        }

        int inverseSum = totalSum + kadaneSum(arr, n);
        // System.out.println("TotalSum" + totalSum);
        // System.out.println("regularSum" + regularSum);
        // System.out.println("inverseSum" + inverseSum);
        return Math.max(regularSum, inverseSum);

    }
}
