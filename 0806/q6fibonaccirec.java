import java.util.Scanner;

public class q6fibonaccirec {

    static int callCount = 0;  // 計數器：紀錄遞迴呼叫次數

    public static int fib(int n) {
        callCount++;  // 每次呼叫就 +1

        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();  // 讀入 n
        callCount = 0;              // 初始化計數器
        int result = fib(n);        // 計算 F(n)

        System.out.println(result);
        System.out.println(callCount);  // 輸出遞迴呼叫次數

        scanner.close();
    }
}
