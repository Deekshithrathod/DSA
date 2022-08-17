import java.util.ArrayList;
import java.util.List;

/**
 * Lecture106
 */
class Node {
    int val;
    Node right;
    Node left;

    Node(int val) {
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class Lecture106 {

    // O(n)
    public static Node findLCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (root.val == n1 || root.val == n2) {
            return root;
        }
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println(LCA(root, 5, 7));
        System.out.println(findLCA(root, 5, 7).val);
    }

    public static int LCA(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        List<Integer> first = new ArrayList<>();
        getPath(root, n1, first);
        List<Integer> second = new ArrayList<>();
        getPath(root, n2, second);
        int i;
        for (i = 0; i < first.size() && i < second.size(); i++) {
            if (first.get(i) != second.get(i)) {
                break;
            }
        }
        return first.get(i - 1);
    }

    public static boolean getPath(Node root, int target, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.val);
        if (root.val == target) {
            return true;
        }

        boolean left = getPath(root.left, target, path);
        boolean right = getPath(root.right, target, path);
        if (left || right) {
            return true;
        }
        // if (!left) {
        // return right;
        // }
        path.remove(path.size() - 1);
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
}