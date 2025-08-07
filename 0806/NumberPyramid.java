import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            // 印升序 1 到 i
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (j != i) {
                    System.out.print(" ");
                }
            }

            // 印降序 i-1 到 1
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(" " + j);
            }

            System.out.println(); // 換行
        }

        scanner.close();
    }
}
