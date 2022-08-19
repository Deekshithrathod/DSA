/**
 * Lecture117
 */
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Lecture117 {
    public static Node first = null;
    public static Node mid = null;
    public static Node last = null;
    public static Node prev = null;

    public static void main(String[] args) {
        // restore the corrupted BST
        Node root = buildTree();
        inOrderTraversal(root);
        restoreBST(root);
        System.out.println();
        inOrderTraversal(root);

    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void restoreBST(Node root) {

        populatePointers(root);

        // if(first != null){
        // swap(first, last);
        // }

        if ((first != null) && (last != null)) {
            swap(first, last);
        } else if (first != null && mid != null) {
            swap(first, mid);
        }
    }

    public static void populatePointers(Node root) {
        if (root == null) {
            return;
        }
        populatePointers(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                mid = root;
            } else {
                last = root;
            }
        }
        prev = root;
        populatePointers(root.right);

    }

    public static Node buildTree() {
        Node root = new Node(4);

        root.left = new Node(5);
        root.right = new Node(2);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // root.right.left = new Node(6);
        root.right.right = new Node(6);

        return root;
    }

    public static void swap(Node node, Node root) {
        int temp = node.val;
        node.val = root.val;
        root.val = temp;
    }
}