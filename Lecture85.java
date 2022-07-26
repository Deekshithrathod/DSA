import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Lecture85 {
    public static void main(String[] args) {
        // Get max rectangle area in the graph
        int arr[] = { 2, 3, 5, 6, 2, 3, 0 };
        System.out.println(largestRectanlge(arr, 7));
        // ArrayList<Integer> ar = Arrays.asList(...arr,0 );
        // System.out.println(maxRectangle(arr, 6));
    }

    // public static int maxRectangle(int arr[], int n) {
    // Stack<Integer> stack = new Stack<>();
    // int answer = 0;
    // for (int i = 0; i < n; i++) {
    // // int k = 1;
    // while (!stack.empty() && (arr[stack.peek()] > arr[i])) {
    // int index = stack.pop();
    // int height = arr[index];
    // if (stack.empty()) {
    // answer = Math.max(answer, height * i);
    // } else {
    // answer = Math.max(answer, height * (i - stack.peek() - 1));
    // }
    // // k++;
    // }
    // stack.push(i);
    // }
    // return answer;
    // }
    public static int largestRectanlge(int arr[], int n) {
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                int index = st.pop();
                int height = arr[index];

                int area = st.empty() ? (height * i) : height * (i - index);
                maxArea = Math.max(maxArea, area);

            }
            st.push(i);
        }
        return maxArea;
    }
}
