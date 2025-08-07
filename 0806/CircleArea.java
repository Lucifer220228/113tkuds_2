import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入半徑
        double radius = scanner.nextDouble();

        // 使用 3.14 計算面積
        double area = 3.14 * radius * radius;

        // 格式化輸出，保留兩位小數
        System.out.printf("%.2f\n", area);

        scanner.close();
    }
}
