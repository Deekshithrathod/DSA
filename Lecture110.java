/**
 * Lecture110
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

public class Lecture110 {
    public static int index = 0;

    public static void main(String[] args) {
        // Construct BST from pre order
        int arr[] = { 10, 2, 1, 13, 11 };
        Node root = constructBST(arr, arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE, 5);
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