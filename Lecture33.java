import java.util.Scanner;

public class Lecture33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int pos = sc.nextInt();
        System.out.println(getBit(n, pos));
        // getBit(n,pos);
    }

    public static int getBit(int n, int pos) {
        return ((n & (1 << pos)) == 0) ? 0 : 1;
    }

    public static int setBit(int n, int pos) {
        return (n | (1 << pos));
    }

    public static int clearBit(int n, int pos) {
        return (n & (~(1 << pos)));
    }

    public static int updateBit(int n, int pos, int value) {
        return (clearBit(n, pos) | (value << pos));
    }
}
