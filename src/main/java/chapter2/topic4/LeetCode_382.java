package chapter2.topic4;

import java.util.Random;

/**
 * @author donald
 * @date 2022/01/16
 *
 * 382. 链表随机节点
 *
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 * - Solution(ListNode head) 使用整数数组初始化对象。
 * - int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 *
 * 示例：
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 *
 * 题意： 随机数
 *
 * 思路：
 * 1. 记录所有链表元素
 * 2. 蓄水池： 该算法会保证每个节点的值成为最后被返回的值的概率均为 1/n ​
 *    证明如下：
 *    P(第 i 个节点的值成为最后被返回的值)
 *  = P(第 i 次随机选择的值=0)×P(第 i+1 次随机选择的值 / 0) * ... * P(第 n 次随机选择的值 / 0)
 *  = 1/i * (1 - 1/(i + 1)) * ... * (1 - 1/n)
 *  = 1/i * i/(i + 1) * ... * (n - 1)/n
 *  = 1/n
 */
public class LeetCode_382 {

    ListNode head;
    int num = 0;

    public LeetCode_382(ListNode head) {

        this.head = head;

        ListNode node = head;
        while (node != null) {

            ++num;
            node = node.next;
        }
    }

    // 暴力法： 记录所有链表元素
    // Faster: 84.79%
    public int getRandom() {
        if (num <= 0) return -1;
        Random random = new Random();
        int i = random.nextInt(this.num);

        ListNode node = this.head;
        while (i -- > 0) {

            node = node.next;
        }

        return node.val;
    }

    // 蓄水池算法
    //
    public int getRandom2() {
        int i = 1, ans = 0;
        Random random = new Random();
        for (ListNode node = head; node != null; node = node.next) {
            if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}