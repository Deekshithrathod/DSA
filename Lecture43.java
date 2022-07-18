public class Lecture43 {
    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 1 } };
        int answer[][] = new int[arr.length][arr.length];
        boolean found = findWayForRat(0, 0, arr, answer);
        if (found) {
            for (int i = 0; i < answer.length; i++) {
                for (int j = 0; j < answer[0].length; j++) {
                    System.out.print(answer[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean findWayForRat(int x, int y, int arr[][], int answer[][]) {

        if (x == arr.length - 1 && y == arr[0].length - 1) {
            answer[x][y] = 1;
            return true;
        }

        if (isSafe(x, y, arr)) {
            answer[x][y] = 1;
            if (findWayForRat(x + 1, y, arr, answer)) {
                return true;
            }
            if (findWayForRat(x, y + 1, arr, answer)) {
                return true;
            }
            answer[x][y] = 0;
            return false;
        }
        return false;
    }

    public static boolean isSafe(int i, int j, int arr[][]) {
        // if (arr[i][j] == 0 || i > arr.length || j > arr[0].length) {
        // return false;
        // }
        // return true;
        if (arr[i][j] == 1 && i < arr.length && j < arr.length) {
            return true;
        }
        return false;
    }
}
