package datastructure.sort;

/**
 * 选择排序
 *
 * 思路： 这个算法把数组分为有序区和无序区，每次都选择无序区中的最大值或最小值，放入有序区中，直到整个数组都有序。
 *
 */
public class SelectSort {

    // Time: O(n^2), Space: O(1)
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            int minIdx = i;
            for (int j = i+1; j < n; ++j)
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            swap(arr, i, minIdx);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Time: O(n^2), Space: O(1)
    public void sortFromEnd(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int n = arr.length;
        for (int i = n-1; i > 0; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j)
                if (arr[j] > arr[maxIdx])
                    maxIdx = j;
            swap(arr, i, maxIdx);
        }
    }
}
