import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // 轉小寫，只保留 a-z
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String cleaned = sb.toString();
        int l = 0, r = cleaned.length() - 1;
        boolean isPalindrome = true;
        while (l < r) {
            if (cleaned.charAt(l) != cleaned.charAt(r)) {
                isPalindrome = false;
                break;
            }
            l++;
            r--;
        }

        System.out.println(isPalindrome ? "Yes" : "No");
    }
}
