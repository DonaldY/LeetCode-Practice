package chapter1.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * 题意：
 * 排列k个有序数组
 *
 * 思路：
 * 1. 每个链表一个指针，分别指向
 * 2. 把所有的数存入数组，然后排序
 * 3.
 */
public class LeetCode_23 {

    // Time: o(k ^ 2 * n), Space: ((k + 2)(k - 1))/2, Faster: 48.22%
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lists.length; ++i) {

            ListNode node = lists[i];

            while (node != null) {

                result.add(node.val);
                node = node.next;
            }
        }

        if (result.size() == 0) return null;

        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                if (integer == null || t1 == null) return -1;
                if (integer > t1) return 1;
                if (integer.equals(t1)) return 0;
                return -1;
            }
        });

        ListNode node = new ListNode(result.get(0));

        ListNode pointer = node;

        for (int i = 1; i < result.size(); ++i) {

            pointer.next = new ListNode(result.get(i));
            pointer = pointer.next;
        }

        return node;
    }
}
