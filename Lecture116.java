/**
 * Lecture116
 */

class Info {

    boolean isBST;
    int min;
    int max;
    int size;
    int ans;

    public Info(boolean isBST, int min, int max, int size, int ans) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.size = size;
        this.ans = ans;
    }
}

public class Lecture116 {

    public static void main(String[] args) {
        // find max BST from the Binary tree
    }

    public static Info largetBSTinBT(Node root) {
        if (root == null) {
            return new Info(true, 0, 0, 0, 0);
        }

        if (root.left == null && root.right == null) {
            return new Info(true, root.val, root.val, 1, 1);
        }

        Info leftInfo = largetBSTinBT(root.left);
        Info rightInfo = largetBSTinBT(root.right);

        Info currInfo = new Info(false, 0, 0, 0, 0);

        currInfo.size = (1 + leftInfo.size + rightInfo.size);

        if (leftInfo.isBST && rightInfo.isBST && leftInfo.max < root.val && rightInfo.min > root.val) {
            currInfo.max = Math.max(leftInfo.max, Math.max(rightInfo.max, root.val));
            currInfo.min = Math.min(leftInfo.min, Math.max(rightInfo.min, root.val));
            currInfo.ans = currInfo.size;
            currInfo.isBST = true;
            return currInfo;
        }

        currInfo.ans = Math.max(rightInfo.ans, leftInfo.ans);
        currInfo.isBST = false;
        return currInfo;
    }

}