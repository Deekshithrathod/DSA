import java.util.Stack;

public class Lecture81 {
    public static void main(String[] args) {
        // here pop is constly and push is O(1)
        CustomQueue customQueue = new CustomQueue();

        customQueue.push(1);
        customQueue.push(2);
        customQueue.push(3);
        customQueue.push(4);
        customQueue.push(5);

        System.out.println(customQueue.empty());
        System.out.println(customQueue.pop());

        System.out.println(customQueue.empty());
        System.out.println(customQueue.pop());

        System.out.println(customQueue.empty());
        System.out.println(customQueue.pop());

        System.out.println(customQueue.empty());
        System.out.println(customQueue.pop());
        customQueue.pop();
        customQueue.pop();
        System.out.println(customQueue.empty());
        // Stack<Integer> st = new Stack<>();
    }

}

class CustomQueue {
    public Stack<Integer> st1 = new Stack<>();
    public Stack<Integer> st2 = new Stack<>();

    public void push(int val) {
        st1.push(val);
    }

    public int pop() {
        if (st1.empty() && st2.empty()) {
            return -1;
        }
        if (!st2.empty()) {
            return st2.pop();
        }

        while (!st1.empty()) {
            st2.add(st1.pop());
        }

        return st2.pop();
    }

    public boolean empty() {
        if (st1.empty() && st2.empty()) {
            return true;
        }
        return false;
    }
}