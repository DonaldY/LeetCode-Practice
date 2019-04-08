package chapter1.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 4
 *
 *
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int [] num1 = new int[] {1, 2};
        int [] num2 = new int[] {3, 4};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();

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
}
