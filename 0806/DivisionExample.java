import java.util.Scanner;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 讀取兩個整數
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        // 計算除法
        int result = (int) a / b;
        
        // 輸出結果，保留兩位小數
        System.out.println(result);
        
        // 關閉掃描器
        scanner.close();
    }
}
