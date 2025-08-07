public class ArrayStatistics {

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        // 統計變數
        int sum = 0;
        double average;
        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;
        int countAboveAvg = 0;
        int evenCount = 0, oddCount = 0;

        // 2. 計算總和、最大最小值與索引
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            sum += n;

            if (n > max) {
                max = n;
                maxIndex = i;
            }
            if (n < min) {
                min = n;
                minIndex = i;
            }

            if (n % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        average = (double) sum / numbers.length;

        // 3. 計算大於平均值的數量
        for (int n : numbers) {
            if (n > average) {
                countAboveAvg++;
            }
        }

        // 4. 表格輸出統計結果
        System.out.println("┌────────────────────────────┐");
        System.out.printf("│ 總和           ：%8d │\n", sum);
        System.out.printf("│ 平均值         ：%8.2f │\n", average);
        System.out.printf("│ 最大值         ：%8d │\n", max);
        System.out.printf("│ 最大值索引位置 ：%8d │\n", maxIndex);
        System.out.printf("│ 最小值         ：%8d │\n", min);
        System.out.printf("│ 最小值索引位置 ：%8d │\n", minIndex);
        System.out.printf("│ 大於平均的數量 ：%8d │\n", countAboveAvg);
        System.out.printf("│ 偶數個數       ：%8d │\n", evenCount);
        System.out.printf("│ 奇數個數       ：%8d │\n", oddCount);
        System.out.println("└────────────────────────────┘");
    }
}
