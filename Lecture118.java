import java.util.Arrays;

import javax.naming.spi.DirStateFactory.Result;

/**
 * Lecture118
 */
public class Lecture118 {

    public static void main(String[] args) {
        // find the max diff possible such that there are k elements out of n (pairwise)
        int arr[] = { 1, 2, 3, 4 };

    }

    public static int findK(int arr[], int n, int k) {
        Arrays.sort(arr);
        int start = arr[0];
        int end = arr[n - 1];
        int ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(arr, n, k, mid)) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return ans;
    }

    public static boolean isFeasible(int arr[], int n, int k, int target) {
        int answer = 0;
        for (int i : arr) {
            if (Math.abs(i - target) > 0) {
                answer++;
            }
        }
        return answer >= k;
    }
}