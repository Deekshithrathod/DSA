import java.util.Stack;

public class Lecture85 {
    public static void main(String[] args) {
        // Get max rectangle area in the graph
        int arr[] = { 2, 3, 5, 6, 2, 3 };
        System.out.println(maxRectangle(arr, 6));
    }

    public static int maxRectangle(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            // int k = 1;
            while (!stack.empty() && (arr[stack.peek()] > arr[i])) {
                int index = stack.pop();
                int height = arr[index];
                if (stack.empty()) {
                    answer = Math.max(answer, height * i);
                } else {
                    answer = Math.max(answer, height * (i - stack.peek() - 1));
                }
                // k++;
            }
            stack.push(i);
        }
        return answer;
    }
}
