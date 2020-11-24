package bytedance.array;

/**
 * @author donald
 * @date 2020/11/24
 *
 * Leetcode 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出：[1,2,2,3,5,6]
 *
 * 思路：
 * 1. 另开辟一个数组，排序完，后赋值给 num1
 * 2. 从后向前比较，然后从后放置
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
public class MergeSortedArray {

    // 方法 1： Time: O(m + n), Space: O(m + n), Faster: 100.00%
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums2 == null) return;

        int [] result = new int[m + n];

        int pm = 0, pn = 0, p = 0;

        while (pm < m && pn < n) {

            if (nums1[pm] < nums2[pn]) result[p ++] = nums1[pm ++];
            else result[p ++] = nums2[pn ++];
        }

        while (pm < m) {

            result[p++] = nums1[pm ++];
        }

        while (pn < n) {

            result[p++] = nums2[pn ++];
        }

        for (int i = 0; i < m + n; ++i) {

            nums1[i] = result[i];
        }
    }
}
