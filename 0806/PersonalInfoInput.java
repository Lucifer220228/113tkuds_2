import java.util.Scanner;

public class PersonalInfoInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String name = scanner.nextLine();
            
            // 如果輸入是空的（按 Enter），就跳出迴圈
            if (name.trim().isEmpty()) {
                break;
            }
            System.out.println(name);
            System.out.println(); 
        }

        scanner.close();
    }
}

