import java.util.*;

class BSTNode {
    int val;
    BSTNode left, right;
    BSTNode(int v) { val = v; }
}

public class M08_BSTRangedSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        String[] vals = sc.nextLine().trim().split(" ");
        String[] range = sc.nextLine().trim().split(" ");
        int L = Integer.parseInt(range[0]);
        int R = Integer.parseInt(range[1]);

        if (n == 0 || vals[0].equals("-1")) {
            System.out.println("Sum: 0");
            return;
        }

        BSTNode root = new BSTNode(Integer.parseInt(vals[0]));
        Queue<BSTNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;
        while (!q.isEmpty() && idx < n) {
            BSTNode cur = q.poll();
            // left child
            if (idx < n && !vals[idx].equals("-1")) {
                cur.left = new BSTNode(Integer.parseInt(vals[idx]));
                q.offer(cur.left);
            }
            idx++;
            // right child
            if (idx < n && !vals[idx].equals("-1")) {
                cur.right = new BSTNode(Integer.parseInt(vals[idx]));
                q.offer(cur.right);
            }
            idx++;
        }

        int sum = rangedSum(root, L, R);
        System.out.println("Sum: " + sum);
    }

    private static int rangedSum(BSTNode node, int L, int R) {
        if (node == null) return 0;
        if (node.val < L) return rangedSum(node.right, L, R);
        if (node.val > R) return rangedSum(node.left, L, R);
        return node.val + rangedSum(node.left, L, R) + rangedSum(node.right, L, R);
    }
}
