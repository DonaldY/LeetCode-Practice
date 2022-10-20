package chapter5.topic2;

/**
 * @author donald
 * @date 2022/10/20
 *
 * 思路：
 * 1. 二分搜索：
 */
public class LeetCode_852 {

    // 方法一： 二分查找
    // Time: O(logn), Space: O(n), Faster: 100.00%
    public int peakIndexInMountainArray(int[] arr) {
        if (null == arr || arr.length == 0) return -1;

        // 根据题意， arr.length >= 3, 所以不会是 0 或者 arr.length - 1
        // 所以从 1, arr.length - 2 开始
        int left = 1, right = arr.length - 2; // 这样做也是为了避免数组下标越界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid; // 找到山峰
            } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
