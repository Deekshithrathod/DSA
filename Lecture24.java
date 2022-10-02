import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Lecture24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // firstRepeatinElement(arr, n);
        // twoElementsSumToTarget(arr, n, target);
        findSmallest(arr, n);
        sc.close();
    }

    // 1. Find the first repeating element
    public static void firstRepeatingElement(int[] arr, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int firstElIndex = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(arr[i])) {
                int index = hm.get(arr[i]);
                firstElIndex = Math.min(index, firstElIndex);
            } else {
                hm.put(arr[i], i);
            }
        }
        System.out.println(arr[firstElIndex]);
    }

    // 2. Find if there are two elements in arr, which add unto target
    public static void twoElementsSumToTarget(int[] arr, int n, int target) {
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

    // 4. Find the if there exists a subarray with target sum
    public static boolean isSubArrayPresent(int[] arr, int target){
        int left = 0;
        int right = 0;

        int currSum = 0;
        while(right<arr.length && currSum < target){
            currSum += arr[right];
            right++;
        }

        while(left < right && right < arr.length){
            if(currSum>target){
                currSum -= arr[left];
                left++;
            }else if(target == currSum){
                return true;
            }
            else {
                currSum += arr[right];
                right++;
            }
        }
        return false;
    }
}
