package datastructure.sort;

/**
 * 插入排序
 *
 * 这个算法把数组分为有序区和无序区，每次都从无序区中拿出一个元素，插入到有序区正确的位置上，使有序区保持有序。
 * 不断重复这个操作，直到整个数组都有序。
 */
public class InsertSort {

    // Time: O(n^2), Space: O(1)
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 1; i < arr.length; ++i) {
            int cur = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = cur;
        }
    }
}
