/**
 * Lecture115
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

public class Lecture115 {
    public static Node findInorderSuccessor(Node root) {
        Node temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args) {
        // Check if two BSTs are identical
        Node root1 = buildTree();
        Node root2 = deleteBST(buildTree(), 5);

        System.out.println(checkBSTIfIdentical(root1, root2));
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

    public static boolean checkBSTIfIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1.val == root2.val) {
            return checkBSTIfIdentical(root1.left, root2.left) && checkBSTIfIdentical(root1.right, root2.right);
        }
        return false;
    }
}