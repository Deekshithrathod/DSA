import java.util.Scanner;

public class Lecture34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt();
        // System.out.println(isPowerOf2(n));
        // System.out.println(numberOfOnes(n));
        generateAllSubsets(new char[] { 'a', 'b', 'c' });
        sc.close();
    }

    public static boolean isPowerOf2(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int numberOfOnes(int n) {
        int countOfOnes = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                countOfOnes++;
            }
            n = (n >> 1);
        }
        return countOfOnes;
    }

    public static void generateAllSubsets(char arr[]) {
        int n = arr.length;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = n - 1; j >= 0; j--) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(arr[n - j - 1] + " ");
                }
            }
            System.out.println();
        }
    }
}
