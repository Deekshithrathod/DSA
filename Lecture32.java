import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Lecture32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // to uppercase
        // String flag = scanner.nextLine();
        // boolean toUpperCase = scanner.nextBoolean();
        // scanner.nextLine();
        String str = scanner.nextLine();
        // if (flag.equals("uppercase")) {
        // toUpperCase = true;
        // }

        // if (toUpperCase) {
        // System.out.println(str.toUpperCase());
        // } else {
        // System.out.println(str.toLowerCase());
        // }
        System.out.println(findCharWithHighestFrequency(str));
        scanner.close();
    }

    public static String biggestNumber(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        String result = "";
        for (int i = charArr.length - 1; i >= 0; i--) {
            result += charArr[i];
        }
        return result;
    }

    public static char findCharWithHighestFrequency(String str) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char result = 'a';
        int maxFrequency = Integer.MIN_VALUE;
        for (char c : str.toCharArray()) {
            if (hm.containsKey(c)) {
                int freq = hm.get(c) + 1;
                hm.put(c, freq);
                if (freq > maxFrequency) {
                    maxFrequency = freq;
                    result = c;
                }
            } else {
                hm.put(c, 1);
            }
        }
        return result;
    }
}
