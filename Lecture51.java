public class Lecture51 {
    public static void waveSort(int arr[], int n) {
        for (int i = 1; i < n; i += 2) {
            if (arr[i - 1] < arr[i]) {
                swap(arr, i, i - 1);
            }

            if (arr[i + 1] < arr[i]) {
                swap(arr, i, i + 1);
            }
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
