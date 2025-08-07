import java.util.Scanner;

public class ScoreToGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();

        if (S >= 90 && S <= 100) {
            System.out.println("A");
        } else if (S >= 80 && S <= 89) {
            System.out.println("B");
        } else if (S >= 70 && S <= 79) {
            System.out.println("C");
        } else if (S >= 60 && S <= 69) {
            System.out.println("D");
        } else if (S >= 0 && S <= 59) {
            System.out.println("F");
        } else {
            System.out.println("Invalid score.");
        }

        scanner.close();
    }
}
