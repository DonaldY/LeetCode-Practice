package chapter1.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 4
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * 题意： 求两个数组中位数
 *
 * 思路： 1. 合并两个数组，求出中间的数（注意奇偶）
 *
 * 2. 如果一个算法要 log，则每次运算，数据集要减少一般
 *
 * 即找到第k小的数
 * f(k)
 * 奇数： f((m + n) / 2 + 1) = f(2) = 2
 * 偶数: (f((m + n) / 2) + f((m + n) / 2 + 1)) / 2 = (f(2) + f(3)) / 2 = 2.5
 *
 * 关键第k小的函数
 */
public class LeetCode_4 {

    public static void main(String[] args) {

        int [] num1 = new int[] {1, 2};
        int [] num2 = new int[] {3, 4};

        LeetCode_4 median = new LeetCode_4();

        System.out.println(median.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        List<Integer> list = new ArrayList<Integer>(len1 + len2);

        for (int i = 0, j = 0; i < len1 || j < len2;) {

            if (i < len1 && j < len2) {

                if (nums1[i] < nums2[j]) {

                    list.add(nums1[i]);
                    ++i;
                } else {

                    list.add(nums2[j]);
                    ++j;
                }

            } else if (i < len1) {

                list.add(nums1[i]);
                ++i;
            } else {

                list.add(nums2[j]);
                ++j;
            }

        }

        int reminder = (len1 + len2) % 2;
        int index = (len1 + len2) / 2;

        if (reminder == 0) {

            return (list.get(index - 1) + list.get(index)) * 1.0 / 2;
        } else {

            return list.get(index);
        }

    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 1) == 1) {
            return findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
        } else {
            double a = findKthSmallestInSortedArrays(nums1, nums2, total / 2);
            double b = findKthSmallestInSortedArrays(nums1, nums2, total / 2 + 1);
            return (a + b) / 2;
        }
    }

    // Time:o(log(k)) <= o(log(m + n)), Space: o(1), Faster: 100.00%
    private double findKthSmallestInSortedArrays(int[] nums1, int[] nums2, int k) {

        int len1 = nums1.length, len2 = nums2.length, base1 = 0, base2 = 0;

        while (true) {

            if (len1 == 0) return nums2[base2 + k - 1];
            if (len2 == 0) return nums1[base1 + k - 1];
            if (k == 1) return Math.min(nums1[base1], nums2[base2]);

            int i = Math.min(k / 2, len1);
            int j = Math.min(k - i, len2);
            int a = nums1[base1 + i - 1], b = nums2[base2 + j - 1];

            if (i + j == k && a == b) return a;

            if (a <= b) {
                base1 += i;
                len1 -= i;
                k -= i;
            }

            if (a >= b) {
                base2 += j;
                len2 -= j;
                k -= j;
            }
        }
    }
}