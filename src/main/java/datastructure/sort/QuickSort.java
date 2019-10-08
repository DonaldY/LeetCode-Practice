package datastructure.sort;

/**
 * 快速排序
 *
 * 特性：不稳定排序
 *
 * 思路：
 * 1. 选基
 * 2. 分割
 * 3. 递归
 *
 * 实现方法：
 * 1） Lomuto 分割方法
 *    实现简单，不易出错，效率差一些
 *
 * 2） 霍尔分割方法
 *
 */
public class QuickSort {

    // Time: O(n * log(n)), Space: O(n)
    public void lomutoSort(int [] arr) {

        if (arr == null || arr.length == 0) return;

        lomutoSort(arr, 0, arr.length - 1);
    }

    private void lomutoSort(int [] arr, int low, int high) {
        if (low < high) {
            int k = lomutoPartition(arr, low, high);
            lomutoSort(arr, low, k - 1);
            lomutoSort(arr, k + 1, high);
        }
    }

    private int lomutoPartition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; ++j) {
            if (arr[j] < pivot) {
                swap(arr, i, high);
                ++i;
            }
        }
        swap(arr, i, high);

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Time: O(n * log(n)), Space: O(n)
    public void hoareSort(int [] arr) {

        if (arr == null || arr.length == 0) return;
        hoareSort(arr, 0, arr.length - 1);
    }

    private void hoareSort(int [] arr, int low, int high) {
        if (low < high) {
            int k = hoarePartition(arr, low, high);
            hoareSort(arr, low, k);
            hoareSort(arr, k + 1, high);
        }
    }

    private int hoarePartition(int [] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int i = low, j = high;
        while (true) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i >= j) return j;
            swap(arr, i++, j--);
        }
    }
}
