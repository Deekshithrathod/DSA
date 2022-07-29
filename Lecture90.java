/**
 * Lecture90
 */
public class Lecture90 {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 0, 1 };
        int k = 2;
        int i = 0, zeroCount = 0, ans = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (arr[i] == 0) {
                    zeroCount--;
                }
                i++;
            }
            ans = Math.max((ans), j - i + 1);
        }
        System.out.println(ans);
        // System.out.println((i + 1) + " " + (j + 1));
    }
}