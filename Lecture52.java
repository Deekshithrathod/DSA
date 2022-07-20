public class Lecture52 {
    public static int mergeSort(int arr[], int start, int end) {
        int inversions = 0;
        if (start < end) {
            int mid = start + ((end - start) / 2);
            inversions += mergeSort(arr, start, mid);
            inversions += mergeSort(arr, mid + 1, end);
            inversions += merge(arr, start, mid, end);
        }
        return inversions;
    }

    public static int merge(int arr[], int start, int mid, int end) {
        int inversions = 0;
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
                inversions = n1 - i;
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
        return inversions;
    }
}
