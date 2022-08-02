package chapter1.topic1;

import java.util.*;

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
 *
 * 3. 两个两个合并
 * 4. 最小堆维护
 * 5. 分治方法
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

        result.sort(Comparator.comparingInt(a -> a));

        ListNode node = new ListNode(result.get(0));

        ListNode pointer = node;

        for (int i = 1; i < result.size(); ++i) {

            pointer.next = new ListNode(result.get(i));
            pointer = pointer.next;
        }

        return node;
    }

    // Time: O(k*n), Space: O(1), Faster: 22.49%
    public ListNode mergeKSortedListsOneByOne(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        for (ListNode list: lists) {
            result = mergeTwoSortedLists(result, list);
        }
        return result;
    }

    private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummy.next;
    }


    // Time: O(n*log(k)), Space: O(k), Faster: 70.34%
    public ListNode mergeKSortedListsMinHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        Queue<ListNode> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list: lists)
            if (list != null)
                q.add(list);
        ListNode dummy = new ListNode(0), p = dummy;

        while (!q.isEmpty()) {
            ListNode min = q.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) q.add(min.next);
        }
        return dummy.next;
    }

    // Time: O(n*log(k)), Space: O(log(k)), Faster: 100.00%
    public ListNode mergeKSortedListsDivideConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);
        return mergeTwoSortedLists(left, right);
    }
}
