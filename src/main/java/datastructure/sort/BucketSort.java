package datastructure.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/08/12
 */
public class BucketSort {

    private int bucketSize;

    public BucketSort(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    // Time(avg): O(n+k), Time(worst): O(n^2), Space: O(n)
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int max = arr[0], min = arr[0];
        // 计算最大值和最小值
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 桶的数量 = 数组长度 / 桶大小
        int bucketCount = arr.length / bucketSize;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; ++i)
            buckets.add(new ArrayList<>());

        for (int num : arr) {
            // 计算放在哪个桶中
            int idx = (int) ((num - min) / (max - min + 1.0) * bucketCount);
            buckets.get(idx).add(num);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);   // 桶内：插入排序
            for (int num : bucket) { // 再放入结果中
                arr[idx++] = num;
            }
        }
    }

    private void insertionSort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return;
        for (int i = 1; i < arr.size(); ++i) {
            int cur = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > cur) { // 先找一个合适的位置
                arr.set(j + 1, arr.get(j));
                --j;
            }
            // 找到合适的位置，放下
            arr.set(j + 1, cur);
        }
    }
}
