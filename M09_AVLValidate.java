import java.util.*;

public class M09_AVLValidate {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { this.val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        Node root = buildTree(arr);

        if (!isBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }

        if (!isAVL(root).isValid) {
            System.out.println("Invalid AVL");
            return;
        }

        System.out.println("Valid");
    }

    // 建立樹：層序陣列 → 二元樹
    private static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node cur = q.poll();
            if (i < arr.length && arr[i] != -1) {
                cur.left = new Node(arr[i]);
                q.offer(cur.left);
            }
            i++;
            if (i < arr.length && arr[i] != -1) {
                cur.right = new Node(arr[i]);
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    // 驗證 BST
    private static boolean isBST(Node root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isBST(root.left, min, root.val) &&
               isBST(root.right, root.val, max);
    }

    // 驗證 AVL，返回高度 + 是否合法
    private static class AVLResult {
        boolean isValid;
        int height;
        AVLResult(boolean v, int h) { isValid = v; height = h; }
    }

    private static AVLResult isAVL(Node root) {
        if (root == null) return new AVLResult(true, 0);
        AVLResult left = isAVL(root.left);
        AVLResult right = isAVL(root.right);

        if (!left.isValid || !right.isValid) return new AVLResult(false, 0);
        if (Math.abs(left.height - right.height) > 1) return new AVLResult(false, 0);

        return new AVLResult(true, Math.max(left.height, right.height) + 1);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 建立樹過程需要走訪陣列一次 O(n)。
 * 2. 驗證 BST 遞迴遍歷每個節點一次 O(n)。
 * 3. 驗證 AVL 也是一次後序遍歷 O(n)。
 * 整體為 O(n)，其中 n 為節點數。
 */
