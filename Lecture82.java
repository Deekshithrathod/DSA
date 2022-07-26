import java.util.LinkedList;
import java.util.Queue;

class CustomStack {
    public int n;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    CustomStack() {
        n = 0;
    }

    public void push(int val) {
        q2.add(val);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }

        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        n++;
    }

    public int pop() {
        if (n == 0) {
            return -1;
        }
        n--;
        return q1.poll();
    }

    public int size() {
        return n;
    }

    public boolean empty() {
        return n == 0;
    }

}

class PopCostlyStack {
    int n;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    PopCostlyStack() {
        n = 0;
    }

    public void push(int val) {
        n++;
        q1.add(val);
    }

    public int pop() {
        while (q1.size() != 1) {
            q2.add(q1.poll());
        }
        n--;
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return q2.poll();
    }

    public int size() {
        return n;
    }

    public boolean empty() {
        return n == 0;
    }
}

public class Lecture82 {
    public static void main(String[] args) {
        // CustomStack stack = new CustomStack();
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // stack.push(5);

        // System.out.println(stack.empty());
        // System.out.println(stack.pop());

        // System.out.println(stack.empty());
        // System.out.println(stack.pop());

        // System.out.println(stack.empty());
        // System.out.println(stack.pop());

        // System.out.println(stack.empty());
        // System.out.println(stack.pop());
        // stack.pop();
        // stack.pop();
        // System.out.println(stack.empty());

        PopCostlyStack popCostlyStack = new PopCostlyStack();
        popCostlyStack.push(1);
        popCostlyStack.push(2);
        popCostlyStack.push(3);
        popCostlyStack.push(4);
        System.out.println(popCostlyStack.empty());
        System.out.println(popCostlyStack.size());
        System.out.println(popCostlyStack.pop());
        System.out.println(popCostlyStack.pop());
        System.out.println(popCostlyStack.pop());
        System.out.println(popCostlyStack.pop());
        System.out.println(popCostlyStack.empty());
    }

    // Stacking using Queues where pop is costly

}
