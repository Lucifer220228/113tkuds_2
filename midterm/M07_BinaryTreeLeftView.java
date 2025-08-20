import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class M07_BinaryTreeLeftView {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        String[] vals = sc.nextLine().trim().split(" ");

        if (n == 0 || vals[0].equals("-1")) {
            System.out.println("LeftView:");
            return;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;
        while (!q.isEmpty() && idx < n) {
            TreeNode cur = q.poll();
            // left child
            if (idx < n && !vals[idx].equals("-1")) {
                cur.left = new TreeNode(Integer.parseInt(vals[idx]));
                q.offer(cur.left);
            }
            idx++;
            // right child
            if (idx < n && !vals[idx].equals("-1")) {
                cur.right = new TreeNode(Integer.parseInt(vals[idx]));
                q.offer(cur.right);
            }
            idx++;
        }

        // BFS 層序，取每層第一個
        List<Integer> leftView = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0) leftView.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        System.out.print("LeftView:");
        for (int v : leftView) {
            System.out.print(" " + v);
        }
        System.out.println();
    }
}
