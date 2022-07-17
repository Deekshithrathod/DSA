import java.util.Scanner;

/**
 * Lecture35
 */
public class Lecture35 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // System.out.println(findUniqueNumber(arr));
        allButTwo(arr);
        sc.close();
    }

    public static int findUniqueNumber(int arr[]) {
        int xorNum = 0;
        for (int i : arr) {
            xorNum = (xorNum ^ i);
        }
        return xorNum;
    }

    public static void allButTwo(int arr[]) {
        int xorNum = findUniqueNumber(arr);

        // find pos of first one in binary representation
        int temp = xorNum;
        int pos = 0;
        int setBit = 0;
        while (setBit != 1) {
            setBit = temp & 1;
            pos++;
            temp = temp >> 1;
        }

        int newXorSum = 0;
        for (int i : arr) {
            if ((i & (1 << (pos - 1))) != 0) {
                newXorSum = (newXorSum ^ i);
            }
        }
        System.out.println(newXorSum);
        System.out.println(newXorSum ^ xorNum);
    }
}