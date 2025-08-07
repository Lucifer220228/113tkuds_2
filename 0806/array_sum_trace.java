public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5}; // 固定的整數陣列
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }

        System.out.println("總和為：" + total);
    }
}

//這個演算法使用一個 for 迴圈遍歷整個陣列一次，每個元素都進行一次加法與輸出操作

//總共執行 n 次（n 為陣列元素個數）

//每次加法與印出操作的時間為常數時間 O(1)

//時間複雜度： O(n)