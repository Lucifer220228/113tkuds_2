class InsertionSortDemo {

    /**
     * 基本插入排序（Insertion Sort）
     *
     * 時間複雜度分析：
     * 最佳情況：O(n)      → 陣列已排序，僅進行 n-1 次比較，不做移動
     * 最壞情況：O(n²)     → 陣列為反序排列，需每次都向左比到頭，共比較與移動 n(n-1)/2 次
     * 平均情況：O(n²)
     *
     * 空間複雜度：O(1) → 原地排序
     * 穩定性：穩定排序（相同元素不改變相對位置）
     *
     * 適合用於小型資料集或資料近乎有序的情況
     */
    static void insertionSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalShifts = 0;

        System.out.println("插入排序過程：");
        System.out.println("已排序部分 | 未排序部分");
        System.out.println("------------|------------");

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            System.out.printf("\n第 %d 步：插入元素 %d\n", i, key);

            // 顯示目前狀態
            System.out.print("插入前：");
            for (int k = 0; k < i; k++) System.out.print(array[k] + " ");
            System.out.print("| ");
            for (int k = i; k < n; k++) {
                if (k == i) System.out.print("[" + array[k] + "] ");
                else System.out.print(array[k] + " ");
            }
            System.out.println();

            // 向左尋找插入位置
            while (j >= 0 && array[j] > key) {
                totalComparisons++;
                System.out.printf("  比較 %d > %d，將 %d 向右移動\n", array[j], key, array[j]);
                array[j + 1] = array[j];
                totalShifts++;
                j--;
            }

            if (j >= 0) totalComparisons++;  // 最後一次比較

            array[j + 1] = key;
            System.out.printf("  將 %d 插入到位置 %d\n", key, j + 1);

            // 顯示插入後狀態
            System.out.print("插入後：");
            for (int k = 0; k <= i; k++) System.out.print(array[k] + " ");
            System.out.print("| ");
            for (int k = i + 1; k < n; k++) System.out.print(array[k] + " ");
            System.out.println();
        }

        System.out.printf("\n排序完成！總比較次數：%d，總移動次數：%d\n",
                totalComparisons, totalShifts);
    }

    /**
     * 二分插入排序（Binary Insertion Sort）
     *
     * 核心概念：使用二分搜尋法尋找插入位置，減少比較次數
     *
     * 時間複雜度分析：
     * 比較次數：
     *   - 最佳：O(n log n)  → 用 binary search 找插入點
     *   - 最壞：O(n log n)
     *   - 平均：O(n log n)
     *
     * 移動（位移）次數：
     *   - 最佳、最壞與平均：O(n²) → 雖然比較快了，但仍需將元素向右挪動，與基本插入排序相同
     *
     * 空間複雜度：O(1)
     * 穩定性：穩定排序
     *
     * 優點：若比較代價遠高於移動代價（如複雜物件），可顯著提升效率
     */
    static void binaryInsertionSort(int[] array) {
        System.out.println("\n二分插入排序過程：");

        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // 使用二分搜尋尋找插入位置
            int insertPos = binarySearchInsertPosition(array, 0, i - 1, key);
            System.out.printf("將 %d 插入到位置 %d\n", key, insertPos);

            // 向右位移以插入 key
            for (int j = i; j > insertPos; j--) {
                array[j] = array[j - 1];
            }

            array[insertPos] = key;
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
        }
    }

    /**
     * 二分搜尋法：找出插入位置
     * 回傳第一個大於 key 的位置
     * 時間複雜度：O(log n)
     */
    static int binarySearchInsertPosition(int[] array, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        int[] numbers2 = numbers1.clone();

        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers1));

        System.out.println("\n=== 基本插入排序 ===");
        insertionSort(numbers1);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers1));

        System.out.println("\n=== 二分插入排序 ===");
        binaryInsertionSort(numbers2);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers2));
    }
}
