public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立一個包含 8 位學生成績的陣列
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. 計算總分與平均分數
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = (double) sum / grades.length;
        System.out.printf("總分: %d\n", sum);
        System.out.printf("平均分數: %.2f\n", average);

        // 3. 找出最高分和最低分及其索引
        int max = grades[0], min = grades[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }
            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }
        System.out.println("最高分: " + max + "，索引位置: " + maxIndex);
        System.out.println("最低分: " + min + "，索引位置: " + minIndex);

        // 4. 計算超過平均分的學生人數
        int countAboveAverage = 0;
        for (int grade : grades) {
            if (grade > average) {
                countAboveAverage++;
            }
        }
        System.out.println("成績超過平均分的學生人數: " + countAboveAverage);

        // 5. 按照「學生編號: 成績」格式輸出
        System.out.println("各學生成績：");
        for (int i = 0; i < grades.length; i++) {
            System.out.println("學生編號 " + i + ": " + grades[i]);
        }
    }
}
