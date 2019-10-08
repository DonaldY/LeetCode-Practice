package datastructure.sort;

/**
 * 归并排序
 *
 * 特性：稳定排序，分治
 *
 * Time: O(n * log(n)), Space: O(n)
 *
 * 递归版思想：
 * 1. 把当前序列平分成两个子序列
 * 2. 递归地对子序列进行排序
 * 3. 把排序好的子序列再合并成一个有序的序列
 *
 * 迭代版本思想：
 * 1. 按照递归版本
 * 2. 维护 len（快长度） 和 low（开始下标）
 *
 */
public class MergeSort {

    // Time: O(n * log(n)), Space: O(n)
    public void sortRecursive(int [] arr) {
        if (arr == null || arr.length == 0) return;

        int [] tmp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    private void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid, tmp);
            mergeSort(arr, mid + 1, high, tmp);
            merge(arr, low, mid, high, tmp);
        }
    }

    private void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, low, k);
    }

    // Time: O(n * log(n)), Space: O(n)
    public void sortIterative(int [] arr) {

        if (arr == null || arr.length == 0) return;

        int n = arr.length;

        int [] tmp = new int[n];

        for (int len = 1; len < n; len = 2 * len) {
            for (int low = 0; low < n; low += 2 * len) {
                int mid = Math.min(low + len - 1, n - 1);
                int high = Math.min(low + 2 * len - 1, n - 1);
                merge(arr, low, mid, high, tmp);
            }
        }
    }
}
