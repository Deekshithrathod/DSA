class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Lecture60 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node newHead = reverseKNodes(head, 2);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static Node reverseKNodes(Node head, int k) {
        // if (head == null) {
        // return head;
        // }
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        int tempK = k;

        while (curr != null && tempK > 0) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            tempK--;
        }
        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }
}
