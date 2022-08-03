/**
 * Lecture94
 */
class Node {
    int val;
    Node left;
    Node right;

    Node(int s) {
        this.val = s;
    }
}

public class Lecture94 {

    public static int index = 0;

    public static Node buildTree(int inOrder[], int preOrder[], int start, int end) {
        if (start > end) {
            return null;
        }
        int curr = preOrder[index];
        index++;

        int pos = searchElement(inOrder, start, end, curr);
        Node n = new Node(inOrder[pos]);
        if (start == end) {
            return n;
        }
        n.left = buildTree(inOrder, preOrder, start, pos - 1);
        n.right = buildTree(inOrder, preOrder, pos + 1, end);
        return n;
    }

    public static int searchElement(int arr[], int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int preOrder[] = { 1, 2, 4, 3, 5 };
        int inOrder[] = { 4, 2, 1, 5, 3 };

        Node head = buildTree(inOrder, preOrder, 0, 4);
        preOrderTraversal(head);
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}