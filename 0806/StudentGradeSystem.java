public class StudentGradeSystem {

    // 方法：根據分數回傳等級
    public static char getGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    // 方法：顯示完整成績報告
    public static void printReport(int[] scores) {
        int aCount = 0, bCount = 0, cCount = 0, dCount = 0;
        int maxScore = scores[0], minScore = scores[0];
        int maxIndex = 0, minIndex = 0;
        int sum = 0;
        int countAboveAvg = 0;

        // 計算總和、最大/最小值與等級統計
        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score > maxScore) {
                maxScore = score;
                maxIndex = i;
            }
            if (score < minScore) {
                minScore = score;
                minIndex = i;
            }

            char grade = getGrade(score);
            switch (grade) {
                case 'A': aCount++; break;
                case 'B': bCount++; break;
                case 'C': cCount++; break;
                case 'D': dCount++; break;
            }
        }

        double average = (double) sum / scores.length;

        // 計算高於平均的人數
        for (int score : scores) {
            if (score > average) {
                countAboveAvg++;
            }
        }

        double aboveAvgPercent = (double) countAboveAvg / scores.length * 100;

        // === 輸出統計摘要 ===
        System.out.println("========= 學生成績報告 =========");
        System.out.println("總人數：" + scores.length);
        System.out.printf("全班平均分數：%.2f\n", average);
        System.out.println("最高分：" + maxScore + "（學生編號：" + maxIndex + "）");
        System.out.println("最低分：" + minScore + "（學生編號：" + minIndex + "）");
        System.out.println("等級統計：A=" + aCount + " B=" + bCount + " C=" + cCount + " D=" + dCount);
        System.out.printf("高於平均分的學生比例：%.2f%%\n", aboveAvgPercent);

        // === 輸出詳細列表 ===
        System.out.println("----------------------------------");
        System.out.println("學生編號\t分數\t等級");
        System.out.println("----------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(i + "\t\t" + scores[i] + "\t" + getGrade(scores[i]));
        }
        System.out.println("==================================");
    }

    public static void main(String[] args) {
        // 1. 建立學生分數陣列
        int[] studentScores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        // 2. 顯示完整報告
        printReport(studentScores);
    }
}
