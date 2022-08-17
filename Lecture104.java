/**
 * Lecture104
 */
public class Lecture104 {

    public static void main(String[] args) {
        // flatten a binary
        Node newHead = flattenBinaryTree(new Node(1));
    }

    public static Node flattenBinaryTree(Node root) {
        flattenBinaryTree(root.left);

        Node temp = root.right;
        // while(temp.ne)
        return new Node(1);
    }
    // Left of each node should be null
    // right of each node should point to the node, that's present next to it in the
    // preorder
}