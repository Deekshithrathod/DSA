/**
 * Lecture111
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

public class Lecture111 {
    public static int index = 0;

    // public static void main(String[] args) {
    // Construct BST from pre order

    public static void main(String[] args) {
        // Check BST
        int arr[] = { 10, 2, 1, 13, };
        // Node root = constructBST(arr, arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE,
        // 5);
        // if check
        Node root = buildTree();
        System.out.println(checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < max && root.val > min) {
            return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
        }
        return false;
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

    public static Node constructBST(int preOrder[], int key, int min, int max, int n) {
        if (index >= n) {
            return null;
        }
        Node root = null;

        if (key < max && key > min) {
            root = new Node(key);
            index++;
            if (index < n) {
                root.left = constructBST(preOrder, preOrder[index], min, key, n);
            }
            if (index < n) {
                root.right = constructBST(preOrder, preOrder[index], key, max, n);
            }
        }
        return root;
    }
}