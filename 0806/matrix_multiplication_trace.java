public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };
        int[][] c = new int[2][2]; // 結果矩陣

        // 三層迴圈進行矩陣相乘
        for (int i = 0; i < 2; i++) { // row of a
            for (int j = 0; j < 2; j++) { // col of b
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                StringBuilder trace = new StringBuilder();
                int sum = 0;
                for (int k = 0; k < 2; k++) {
                    int mul = a[i][k] * b[k][j];
                    sum += mul;
                    trace.append(a[i][k] + "*" + b[k][j]);
                    if (k == 0) trace.append(" + ");
                }
                System.out.println(trace + " = " + sum);
                c[i][j] = sum;
            }
        }

        // 印出結果矩陣
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*此程式使用三層巢狀迴圈來執行矩陣乘法：
for (int i = 0; i < n; i++)       // 外層：列
  for (int j = 0; j < n; j++)     // 中層：行
    for (int k = 0; k < n; k++)   // 內層：乘加
對於 n x n 的矩陣乘法，每個位置都需要 n 次乘法與加總操作，因此：

時間複雜度為： O(n³)

即使這裡是 2x2 小矩陣，演算法結構仍是立方級。
*/