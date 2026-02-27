/**
 * @Auther: Yuming_Huang
 * @Date: 2026/2/27 - 02 - 27 - 15:45
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        // 测试用例
        int[] array = {38, 27, 43, 3, 9, 82, 10, 5};

        System.out.println("=== 归并排序演示 ===");
        System.out.println("排序前: " + arrayToString(array));
        System.out.println();

        // 执行归并排序
        mergeSort(array, 0, array.length - 1);

        System.out.println();
        System.out.println("排序后: " + arrayToString(array));

        // 验证排序结果
        System.out.println("\n=== 验证结果 ===");
        System.out.println("排序是否正确: " + isSorted(array));
    }

    /**
     * 归并排序主方法（递归分解）
     * @param array 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return; // 递归终止条件：只有一个元素
        }

        // 计算中间位置，防止溢出
        int mid = left + (right - left) / 2;

        System.out.println("分解: [" + left + "-" + right + "] -> [" + left + "-" + mid + "] 和 [" + (mid + 1) + "-" + right + "]");

        // 递归排序左半部分
        mergeSort(array, left, mid);

        // 递归排序右半部分
        mergeSort(array, mid + 1, right);

        // 合并两个有序子数组
        System.out.print("合并: ");
        merge(array, left, mid, right);
        System.out.println(arrayToString(array));
    }

    /**
     * 合并两个有序子数组
     * @param array 原数组
     * @param left 左边界
     * @param mid 中间位置
     * @param right 右边界
     */
    public static void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组
        int[] temp = new int[right - left + 1];
        int i = left;      // 左半部分指针
        int j = mid + 1;   // 右半部分指针
        int k = 0;         // 临时数组指针

        // 比较两个子数组的元素，将较小的放入临时数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        // 复制左半部分剩余元素
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // 复制右半部分剩余元素
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 将临时数组复制回原数组
        for (int m = 0; m < temp.length; m++) {
            array[left + m] = temp[m];
        }
    }

    /**
     * 将数组转换为字符串
     */
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 验证数组是否已排序
     */
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
