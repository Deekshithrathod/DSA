public class Lecture44 {
    public static void main(String[] args) {
        int n = 4;
        int arr[][] = new int[n][n];
        nQueen(0, arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean nQueen(int col, int arr[][]) {
        int n = arr.length;
        if (col >= arr.length) {
            return true;
        }
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, arr)) {
                arr[row][col] = 1;
                if (nQueen(col + 1, arr)) {
                    return true;
                }
                arr[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int r, int c, int arr[][]) {
        for (int i = 0; i < c; i++) {
            if (arr[r][i] == 1) {
                return false;
            }
        }

        // top left
        int i = r, j = c;
        while (i >= 0 && j >= 0) {
            if (arr[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }
        // bottom left
        i = r;
        j = c;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == 1) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
