import java.util.*;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long g = gcd(a, b);
        long l = (a / g) * b;  // 避免溢位
        System.out.println("GCD: " + g);
        System.out.println("LCM: " + l);
    }

    private static long gcd(long x, long y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}

/*
 * Time Complexity: O(log(min(a,b)))
 * 說明：
 * 1. 遞迴歐幾里得演算法，每次取模會使數字快速縮小。
 * 2. 最多遞迴深度與 log(min(a, b)) 成正比。
 * 3. LCM 計算為 O(1)，整體即 O(log(min(a,b)))。
 */
