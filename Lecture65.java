class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Lecture65 {

    public static void main(String[] args) {
        Node l1 = createLL(2, 10, new Node(1), 1);
        Node l2 = createLL(19, 6, new Node(15), 1);

        Node head = recursiveMerge(l1, l2);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static Node mergeTwoSortedLL(Node list, Node anotherList) {
        Node temp = new Node(-1);
        Node dummyNode = temp;
        while (list != null && anotherList != null) {
            if (list.val < anotherList.val) {
                dummyNode.next = list;
                list = list.next;
            } else {
                dummyNode.next = anotherList;
                anotherList = anotherList.next;
            }
            dummyNode = dummyNode.next;
        }
        while (list != null) {
            dummyNode.next = list;
            list = list.next;
            dummyNode = dummyNode.next;
        }

        while (anotherList != null) {
            dummyNode.next = anotherList;
            anotherList = anotherList.next;
            dummyNode = dummyNode.next;
        }

        return temp.next;
    }

    public static Node recursiveMerge(Node list, Node anotherList) {
        if (list == null) {
            return anotherList;
        }
        if (anotherList == null) {
            return list;
        }

        Node answer;

        if (list.val < anotherList.val) {
            answer = list;
            answer.next = recursiveMerge(list.next, anotherList);
            // return answer;
        } else {
            answer = anotherList;
            answer.next = recursiveMerge(list, anotherList.next);
        }
        return answer;
    }

    public static Node createLL(int start, int n, Node head, int increment) {
        Node temp = head;
        for (int i = start; i <= (start + n); i += increment) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head;
    }
}
