public class Lecture58 {
    public static void deleteNode(Node head, int val) {
        if (head.val == val) {
            head = head.next;
            return;
        }
        Node temp = head;
        Node prev = null;

        while (temp != null && temp.val != val) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = prev.next.next;
    }
}
