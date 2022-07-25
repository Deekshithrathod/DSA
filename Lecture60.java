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
        Node head = createLL(10, new Node(1));

        Node newHead = reverseKNodes(head, 4);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static Node createLL(int n, Node head) {
        Node temp = head;
        for (int i = 2; i <= n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head;
    }

    public static Node reverseKNodes(Node head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;

        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKNodes(next, k);
        }
        return prev;
    }
}
