public class Lecture49 {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 3, 4, 1, 1, 4, 2, 1 };
        int n = arr.length;
        int max = 4;
        int answer[] = countSort(arr, n, max);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static int[] countSort(int arr[], int n, int max) {
        int freq[] = new int[max + 1];
        int answer[] = new int[n];
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            freq[i] = freq[i] + freq[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            // int i ndex = freq[arr[i]];
            // while (index >= 0 && answer[index] != 0) {
            // index--;
            // }
            // freq[arr[i]] = index;
            answer[--freq[arr[i]]] = arr[i];
        }
        return answer;
    }
}
