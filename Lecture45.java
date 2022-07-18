public class Lecture45 {
    public static void main(String[] args) {
        int arr[] = { 9, 4, 5, 6, 7, 8, 1, 2, 3, 10 };
        int n = 10;
        mergeSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int arr[], int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int a[] = new int[n1];
        int b[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            a[i] = arr[start + i];
        }

        for (int i = 0; i < n2; i++) {
            b[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
                k++;
            } else {
                arr[k] = b[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = b[j];
            j++;
            k++;
        }
    }
}
