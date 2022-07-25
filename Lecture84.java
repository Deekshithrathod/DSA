import java.util.Deque;
import java.util.LinkedList;

/**
 * Lecture84
 */
public class Lecture84 {

    public static void main(String[] args) {
        // int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int arr[] = { 3, 4, 9, 1, -4, 10 };
        slidingWindowMax(arr, 6, 2);
        // deque.addFirst(e);
    }

    // Sliding window Maximum
    public static void slidingWindowMax(int arr[], int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        System.out.print(arr[deque.peekFirst()] + " ");

        for (int i = k; i < n; i++) {
            if (deque.peekFirst() == i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            System.out.print(arr[deque.peekFirst()] + " ");
        }
    }
}