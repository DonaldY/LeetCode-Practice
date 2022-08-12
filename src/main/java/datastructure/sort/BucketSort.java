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
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int bucketCount = arr.length / bucketSize;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; ++i)
            buckets.add(new ArrayList<>());

        for (int num : arr) {
            int idx = (int) ((num - min) / (max - min + 1.0) * bucketCount);
            buckets.get(idx).add(num);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            insertionSort(bucket);
            for (int num : bucket)
                arr[idx++] = num;
        }
    }

    private void insertionSort(List<Integer> arr) {
        if (arr == null || arr.size() == 0) return;
        for (int i = 1; i < arr.size(); ++i) {
            int cur = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > cur) {
                arr.set(j + 1, arr.get(j));
                --j;
            }
            arr.set(j + 1, cur);
        }
    }
}
