/**
 * Lecture103
 */
public class Lecture103 {

    public static void main(String[] args) {
        // Find shortest distance between two nodes
    }

    public static int distanceBetweenNodes(Node n1, Node n2) {

        return -1;
    }

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.val == n1 || root.val == n2) {
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static int totalDist(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        Node lca = LCA(root, n1, n2);
        int d1 = findDist(lca, n1, 0);
        int d2 = findDist(lca, n1, 0);
        return d1 + d2;
    }

    public static int findDist(Node root, int target, int dist) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            return target;
        }

        int left = findDist(root, target, dist + 1);
        if (left != -1) {
            return left;
        }

        // int right = findDist(root, target, dist+1);
        // if(right != -1){
        return findDist(root, target, dist + 1);
        // }

    }
}