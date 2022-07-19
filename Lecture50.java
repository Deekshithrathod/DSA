/**
 * Lecture50
 */
public class Lecture50 {

    public static void main(String[] args) {
        // DNF sort
        int arr[] = { 2, 2, 2, 1, 1, 1, 0, 0, 0, 0, 1, 2 };
        int n = arr.length;
        dnfSort(arr, n);
    }

    public static void dnfSort(int arr[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, high, mid);
                high--;
                // mid++;
            }
        }

        // System.out.println(mid + high);
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // for (int i = 0; i < low; i++) {
        // System.out.print(0 + " ");
        // }

        // for (int i = 0; i < mid; i++) {
        // System.out.print(1 + " ");
        // }

        // for (int i = 0; i < high; i++) {
        // System.out.print(2 + " ");
        // }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}