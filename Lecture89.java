import java.util.Arrays;

/**
 * Lecture89
 */
public class Lecture89 {

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 7, 8, 9, 1, 2 };
        int target = 6;
        Arrays.sort(arr);
        int n = arr.length;
        boolean answer = false;
        for (int i = 0; i < n - 2; i++) {
            answer = twoPointerSearch(arr, i + 1, n - 1, target - arr[i]);
            if (answer) {
                break;
            }
        }
        System.out.println(answer);
    }

    public static boolean twoPointerSearch(int arr[], int startIndex, int endIndex, int target) {
        while (startIndex < endIndex) {
            int value = arr[startIndex] + arr[endIndex];
            if (value == target) {
                return true;
            } else if (value > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        return false;
    }
}