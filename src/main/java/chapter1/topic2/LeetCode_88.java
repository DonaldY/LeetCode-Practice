package chapter1.topic2;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 *
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * 题意：合并两个有序数组
 * 1. 比较两个数组，把最终值放入第三个数组，再赋值（不行，题意是在nums1数组上，即地址不能不变）
 * 2. 合并两个数组，直接排序
 * 3. 从后向前比较，然后从后放置
 *
 *    [1, 2, 3, 0, 0, 0]
 *           ^        ^
 *           |        |
 *           p1       p
 *
 *    [2, 5, 6]
 *           ^
 *           |
 *           p2
 */
public class LeetCode_88 {

    public static void main(String[] args) {

        LeetCode_88 leetCode = new LeetCode_88();
        leetCode.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int [] arr = new int[m + n];

        int index = 0, i = 0, j = 0;

        while (i < m && j < n) {

            if (nums1[i] < nums2[j]) {

                arr[index++] = nums1[i];
                ++i;
            } else {

                arr[index++] = nums2[j];
                ++j;
            }
        }

        while (i < m) {

            arr[index++] = nums1[i++];
        }

        while (j < n) {

            arr[index++] = nums2[j++];
        }

        nums1 = arr;
    }

    // Time: o(n^2) Space: o(1) faster: 100%
    public void mergeWithSort(int[] nums1, int m, int[] nums2, int n) {

        int index = 0;

        while (m < nums1.length) {

            nums1[m++] = nums2[index++];
        }

        Arrays.sort(nums1);
    }

    // Time: o(m + n) Space: o(1)
    public void mergeWithNoSort(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1, i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] < nums2[j]) {

                nums1[index--] = nums2[j--];
            } else {

                nums1[index--] = nums1[i--];
            }
        }

        while (j >= 0) {

            nums1[index--] = nums2[j--];
        }
    }
}
