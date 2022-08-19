import java.util.Deque;
import java.util.LinkedList;

/**
 * Lecture114
 */
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class Lecture114 {

    public static void main(String[] args) {
        Node root = buildTree();
        zigZagTraversal(root);
    }

    public static Node buildTree() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        return root;
    }

    public static void zigZagTraversal(Node root) {
        Deque<Node> level = new LinkedList<>();

        boolean leftToRight = false;
        level.add(root);

        while (!level.isEmpty()) {
            int n = level.size();
            for (int i = 0; i < n; i++) {
                Node curr;
                if (leftToRight) {
                    curr = level.pollFirst();
                } else {
                    curr = level.pollLast();
                }
                System.out.print(curr.val + " ");
                if (leftToRight) {
                    if (curr.left != null)
                        level.add(curr.left);
                    if (curr.right != null)
                        level.add(curr.right);
                } else {

                    if (curr.right != null)
                        level.addFirst(curr.right);
                    if (curr.left != null)
                        level.addFirst(curr.left);
                }
            }
            leftToRight = (!leftToRight);
            System.out.println();
        }
    }
}