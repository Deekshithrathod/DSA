import java.util.Arrays;

public class Lecture31 {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "ily";
        // s1 = "";
        System.out.println(s1 + s2);
        // System.out.println(s1.charAt(0));
        System.out.println(s1.compareTo(s2));
        // System.out.println(s2.indexOf("i"));
        char temp[] = s1.toCharArray();
        Arrays.sort(temp);
        System.out.println(new String(temp));

        return;

    }
}
