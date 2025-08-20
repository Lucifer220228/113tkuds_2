import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int val;
        char color; // 'B' or 'R'
        int index;
        Node left, right;
        Node(int v, char c, int idx) {
            val = v;
            color = c;
            index = idx;
        }
    }

    static Node buildTree(int n, int[] vals, char[] colors) {
        if (n == 0) return null;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            if (vals[i] == -1) {
                nodes[i] = null; // null node
            } else {
                nodes[i] = new Node(vals[i], colors[i], i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int li = 2 * i + 1, ri = 2 * i + 2;
                if (li < n) nodes[i].left = nodes[li];
                if (ri < n) nodes[i].right = nodes[ri];
            }
        }
        return nodes[0];
    }

    // check black height consistency
    static int checkBlackHeight(Node root) {
        if (root == null) return 1; // NIL 視為黑，算 1
        int lh = checkBlackHeight(root.left);
        if (lh == -1) return -1;
        int rh = checkBlackHeight(root.right);
        if (rh == -1) return -1;
        if (lh != rh) return -1; // mismatch
        return lh + (root.color == 'B' ? 1 : 0);
    }

    // DFS 檢查 red-red
    static boolean checkRedRed(Node root) {
        if (root == null) return true;
        if (root.color == 'R') {
            if ((root.left != null && root.left.color == 'R') ||
                (root.right != null && root.right.color == 'R')) {
                System.out.println("RedRedViolation at index " + root.index);
                return false;
            }
        }
        return checkRedRed(root.left) && checkRedRed(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        int[] vals = new int[n];
        char[] colors = new char[n];
        for (int i = 0; i < n; i++) {
            vals[i] = sc.nextInt();
            colors[i] = sc.next().charAt(0);
            if (vals[i] == -1) colors[i] = 'B'; // null node 視為黑
        }

        Node root = buildTree(n, vals, colors);

        // 1) root must be black
        if (root != null && root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }

        // 2) red-red violation
        if (!checkRedRed(root)) return;

        // 3) black height consistency
        int res = checkBlackHeight(root);
        if (res == -1) {
            System.out.println("BlackHeightMismatch");
            return;
        }

        System.out.println("RB Valid");
    }
}
