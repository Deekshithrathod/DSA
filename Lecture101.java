import java.util.LinkedList;
import java.util.Queue;

/**
 * Lecture101
 */
public class Lecture101 {

    public static void main(String[] args) {
        // rightView()
    }

    public static void rightView(Node root) {
        // building the right tree view
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();

            while (n > 0) {
                Node currNode = q.poll();
                if (n == 1) {
                    System.out.println(currNode.val);
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
                n--;
            }

            // int k=1;
            // while(k<n){
            // q.remove();
            // }

            // Node currNode
        }
    }
}