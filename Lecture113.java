import java.util.ArrayList;

/**
 * Lecture113
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

public class Lecture113 {

    public static void main(String[] args) {
        ArrayList<Node> trees = getAllBSTs(1, 3);

        for (Node tree : trees) {
            inOrderTraversal(tree);
            System.out.println();
        }
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public static ArrayList<Node> getAllBSTs(int start, int end) {
        ArrayList<Node> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<Node> leftTrees = getAllBSTs(start, i - 1);
            ArrayList<Node> rightTrees = getAllBSTs(i + 1, end);

            for (int j = 0; j < leftTrees.size(); j++) {
                for (int k = 0; k < rightTrees.size(); k++) {
                    Node tree = new Node(i);
                    tree.left = leftTrees.get(j);
                    tree.right = rightTrees.get(k);
                    trees.add(tree);
                }
            }
        }
        return trees;
    }
}