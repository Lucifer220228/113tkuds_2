
import java.util.Scanner;

public class FormatFloat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        System.out.printf("%.2f\n", number);
        scanner.close();
    }
}
