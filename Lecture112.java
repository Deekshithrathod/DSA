/**
 * Lecture112
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

public class Lecture112 {

    public static void main(String[] args) {
        // sorted array to BST
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Node root = sortedToBST(arr, 0, 9);
        inOrderTraversal(root);
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

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static Node sortedToBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedToBST(arr, start, mid - 1);
        root.right = sortedToBST(arr, mid + 1, end);
        return root;
    }
}