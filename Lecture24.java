import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Lecture24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int target = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // firstRepeatinElement(arr, n);
        // twoElementsSumToTarget(arr, n, target);
        findSmallest(arr, n);
        sc.close();
    }

    // 1. Find the first repeating element
    public static void firstRepeatinElement(int arr[], int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int firstElIndex = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int index = hm.get(arr[i]);
                // if(index < firstElIndex)
                firstElIndex = Math.min(index, firstElIndex);
            } else {
                hm.put(arr[i], i);
            }
        }
        System.out.println(arr[firstElIndex]);
    }

    // 2. Find if there are two elements in arr, which add upto target
    public static void twoElementsSumToTarget(int arr[], int n, int target) {
        // sort the array
        Arrays.sort(arr);
        int l = 0, r = n - 1;

        while (l < r && l < n - 1) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                System.out.println(true);
                return;
            } else if (sum > target) {
                r--;
                // System.out.println;
            } else {
                l++;
            }
        }
        System.out.println("not found");
    }

    // 3. find the missing smallest +ve number
    public static void findSmallest(int arr[], int n) {
        int maxLimit = 1000001;

        boolean info[] = new boolean[maxLimit];
        info[0] = true;
        for (int i : arr) {
            if (i > 0)
                info[i] = true;
        }

        for (int i = 1; i < maxLimit; i++) {
            if (!info[i]) {
                System.out.println("printing " + i);
                return;
            }
        }
    }
}
