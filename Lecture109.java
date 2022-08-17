/**
 * Lecture109
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

    // No1
    // this is my first line o that I mm ever writing k you woouuldn kno
}

public class Lecture109 {
    public static Node findInorderSuccessor(Node root) {
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public static Node deleteBST(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val > target) {
            root.left = deleteBST(root.left, target);
        } else if (root.val < target) {
            root.right = deleteBST(root.right, target);
        } else {
            if (root.right == null) {
                // Node temp =;
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }

            Node succ = findInorderSuccessor(root.left);
            root.val = succ.val;
            root.left = deleteBST(root.left, succ.val);
        }
        return root;
    }

    public static void main(String[] args) {
        // search in BST
        // delete in BST
        Node root = buildTree();
        inOrderTraversal(root);
        System.out.println();

        deleteBST(root, 5);

        inOrderTraversal(root);
        System.out.println();
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static Node buildTree() {
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        // root.right.left = new Node(6);
        root.right.right = new Node(6);

        return root;
    }
}