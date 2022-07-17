import java.util.Scanner;

public class Lecture40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        // towerOfHanoi('A', 'C', 'B', 3);
        sc.close();
        // reverseString(s);
        // System.out.println(s.substring(s.length() + 2));
        System.out.println();
        // System.out.println(removeAllDuplicates(s));
        System.out.println(moveAllX(s));
    }

    public static void reverseString(String str) {
        if (str.length() == 0) {
            return;
        }
        reverseString(str.substring(1));
        System.out.print(str.charAt(0));
    }

    public static void towerOfHanoi(char src, char dest, char helper, int n) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(src, helper, dest, n - 1);
        System.out.println(n + ":" + src + "->" + dest);
        towerOfHanoi(helper, dest, src, n - 1);

        // towerOfHanoi(A, C, B, n - 1);
        // System.out.println(n + ":" + A + "->" + B);
        // towerOfHanoi(B, C, A, n - 1);
    }

    public static String removeAllDuplicates(String str) {
        if (str.length() == 1) {
            return str;
        }
        char currChar = str.charAt(0);
        String restString = removeAllDuplicates(str.substring(1));
        return (restString.charAt(0) == currChar) ? restString : currChar + restString;

    }

    public static String moveAllX(String str) {
        if (str.length() == 0) {
            return "";
        }
        char currChar = str.charAt(0);
        String restString = moveAllX(str.substring(1));
        return (currChar == 'x') ? restString + "x" : currChar + restString;
    }
}
