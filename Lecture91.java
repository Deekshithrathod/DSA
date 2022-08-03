import java.util.Arrays;
import java.util.Scanner;

/**
 * Lecture91
 */
public class Lecture91 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int arr[] = new int[26];
        Arrays.fill(arr, -1);
        sc.close();

        int start = -1;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int index = ch - 'a';
            if (arr[index] > start) {
                start = arr[index];
            }
            arr[index] = i;
            answer = Math.max(answer, i - start);
        }
        System.out.println(answer);
    }
}