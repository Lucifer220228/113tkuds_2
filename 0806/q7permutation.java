import java.util.Scanner;

public class q7permutation {
    static int count = 0; // 用來統計排列數

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] nums = new int[n];
        boolean[] used = new boolean[n];

        // 初始化數字 1~n
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        int[] current = new int[n];
        permute(nums, used, current, 0);

        System.out.println(count); // 印出總排列數（ops）
    }

    // 遞迴產生排列
    public static void permute(int[] nums, boolean[] used, int[] current, int depth) {
        if (depth == nums.length) {
            for (int i = 0; i < current.length; i++) {
                System.out.print(current[i]);
                if (i < current.length - 1) System.out.print(" ");
            }
            System.out.println();
            count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current[depth] = nums[i];
                permute(nums, used, current, depth + 1);
                used[i] = false;
            }
        }
    }
}
