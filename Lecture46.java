public class Lecture46 {
    public static void main(String[] args) {
        int arr[] = { 9, 4, 5, 6, 7, 8, 1, 2, 3, 10 };
        int n = 10;
        quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pivot = findPivot(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
            // quickSort(arr, start, end);
        }
    }

    public static int findPivot(int arr[], int start, int end) {
        int i = start - 1;
        int pivot = arr[end];

        for (int k = start; k < end; k++) {
            if (arr[k] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

}
