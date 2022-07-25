class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Lecture67 {
    public static Node createLL(int n, Node head, int increment) {
        Node temp = head;
        for (int i = 2; i <= (n); i += increment) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = createLL(10, new Node(1), 1);
        Node newHeNode = oddEven(head);
        while (newHeNode != null) {
            System.out.print(newHeNode.val + " ");
            newHeNode = newHeNode.next;
        }
    }

    public static Node oddEven(Node head) {
        if (head == null) {
            return head;
        }
        Node oddStart = head;
        Node oddTail = oddStart;

        Node evenStart = head.next;
        Node evenTail = evenStart;

        while (oddTail != null && evenTail != null && oddTail.next != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        // 1->2->3->4->5->6

        oddTail.next = evenStart;
        return oddStart;
    }
}
