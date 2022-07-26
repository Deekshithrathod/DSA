import java.util.Stack;

public class Lecture86 {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trappedWater(arr, 12));
    }

    public static int trappedWater(int arr[], int n) {
        int water = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && arr[st.peek()] < arr[i]) {
                int index = st.pop();
                int height = arr[index];
                if (st.empty()) {
                    break;
                }
                water += ((Math.min(arr[st.peek()], arr[i]) - height) * (i - index));

            }
            st.push(i);
        }
        return water;
    }
}
