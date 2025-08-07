import java.util.Scanner;

public class AddIntAndDouble {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        double b = scanner.nextDouble();

        double sum = a + b;

        System.out.printf("%.2f\n", sum);

        scanner.close();
    }
}
