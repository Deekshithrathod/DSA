class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Lecture59 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        Node newHead = recursiveReversing(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    public static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        // curr.next = prev;
        return prev;
    }

    public static Node recursiveReversing(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // if(head.next == null){
        // return head;
        // }
        Node newHead = recursiveReversing(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
