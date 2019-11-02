package datastructure.sort;

/**
 * 希尔排序
 *
 * 希尔排序通过引入步长 gap，将数组分成多个子序列分别进行插入排序，这样可以让一个元素朝最终位置跳跃一大步。
 * 步长在每一轮排序后递减，最后减至 1，变成简单插入排序。这个时候，数组已经基本有序，只需要再做少量的对比和移动即可完成最后的排序。
 *
 *
 */
public class ShellSort {

    // Time: O(n^2), Space: O(1)
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int gap = arr.length>>1; gap > 0; gap >>= 1) {
            for (int i = gap; i < arr.length; ++i) {
                int cur = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > cur) {
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = cur;
            }
        }
    }

    // Time: O(n^2), Space: O(1)
    public void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; ++i) {
            int cur = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = cur;
        }
    }
}
