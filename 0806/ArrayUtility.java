import java.util.Arrays;

public class ArrayUtility {

    // 列印陣列內容，格式為 [元素1, 元素2, ...]
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    // 原地反轉陣列
    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // 建立陣列的副本
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    // 找出第二大的數值
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }

        return secondMax;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] original = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        // 2-1. printArray
        System.out.print("原始陣列：");
        printArray(original);

        // 2-2. copyArray
        int[] copied = copyArray(original);
        System.out.print("複製陣列：");
        printArray(copied);

        // 2-3. reverseArray（反轉原始陣列）
        reverseArray(original);
        System.out.print("反轉後的原始陣列：");
        printArray(original);

        // 2-4. findSecondLargest
        int secondLargest = findSecondLargest(copied);
        System.out.println("複製陣列中的第二大值是：" + secondLargest);
    }
}
