package datastructure.sort;

/**
 *
 * 描述
 * 堆排序是一种基于比较的排序算法。
 * 它的算法思想和选择排序相似，都是把数组分为有序区和无序区，每次都从无序区中取最大值或最小值，放入有序区，直到整个数组有序。
 * 和选择排序的区别是，堆排序使用了一个二叉堆来组织无序区中的数据，以此减少从无序区中查找最值的时间。
 *
 * 二叉堆逻辑上是一棵完全二叉树，但实际上存储在一维数组中即可。
 * 根据堆是最大堆还是最小堆的不同，具有不同的性质。在最大堆中，树上任意节点的值都大于等于它的子节点。
 * 而在最小堆中，树上任意节点的值都小于等于它的子节点。
 */
public class HeapSort {

    private void swap(int[] arr, int i, int j) {

    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;

        buildMaxHeap(arr, arr.length - 1);

        for (int end = arr.length - 1; end > 0; --end) {
            swap(arr, 0, end);
            siftDown(arr, 0, end - 1);
        }
    }

    private void buildMaxHeap(int[] arr, int end) {
        for (int i = end / 2; i >= 0; --i) {
            siftDown(arr, i, end);
        }
    }

    private void siftDown(int[] arr, int i, int end) {
        int parent = i, child = 2 * parent + 1;
        while (child <= end) {
            if (child + 1 <= end && arr[child + 1] > arr[child]) ++child;
            if (arr[parent] >= arr[child]) break;
            swap(arr, parent, child);
            parent = child;
            child = 2 * parent + 1;
        }
    }
}
