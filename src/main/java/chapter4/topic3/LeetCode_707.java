package chapter4.topic3;

/**
 * @author donald
 * @date 2021/04/3
 *
 * LeetCode 707. 设计链表
 *
 * 设计链表的实现。您可以选择使用单链表或双链表。
 * 单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 *                       如果 index 等于链表的长度，则该节点将附加到链表的末尾。
 *                       如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * ```
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * ```
 *
 * 题意： 设计链表
 *
 * 思路： 单链表就可满足(满足不了删除尾节点快速)
 *       0. 节点
 *       1. 头指针
 *       2. 尾指针
 *       3. 总数
 *
 */
public class LeetCode_707 {
}

// Faster: 85.25%
class MyLinkedList {

    class Node {
        private int val;
        private Node next;
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int total;

    public MyLinkedList() {
        head = new Node(-1);
        tail = new Node(-1);
        this.total = 0;
    }

    public int get(int index) {
        if (total <= index || index < 0) {
            return -1;
        }
        Node pre = head;
        while (index -- >= 0) {
            pre = pre.next;
        }
        return pre.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        if (total == 0) {
            tail.next = node;
        }
        ++total;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (total == 0) {
            head.next = node;
        }
        if (null != tail.next) {
            tail.next.next = node;
        }
        tail.next = node;
        ++total;
    }

    public void addAtIndex(int index, int val) {
        if (index > total) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == total) {
            addAtTail(val);
            return;
        }
        Node pre = findPreNodeByIndex(index);
        Node now = new Node(val);
        now.next = pre.next;
        pre.next = now;
        ++ total;
    }

    private Node findPreNodeByIndex(int index) {
        Node pre = head;
        while (index -- > 0) {
            pre = pre.next;
        }
        return pre;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= total) return;
        if (index == 0) {
            Node next = head.next;
            head.next = next.next;
            next.next = null;
            -- total;
            return;
        }
        Node pre = findPreNodeByIndex(index);
        if (index + 1 == total) {
            tail.next = pre;
        }
        Node next = pre.next;
        pre.next = next.next;
        next.next = null;
        -- total;
    }

    public static void main(String[] args) {

        /**
         * ["MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
         * [[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]
         *
         *
         */
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(4);
        System.out.println(obj.get(1)); // 4
        obj.addAtHead(1); // 1 4
        obj.addAtHead(5); // 5 1 4
        obj.deleteAtIndex(3); //
        obj.addAtHead(7); //
        System.out.println(obj.get(3));
        System.out.println(obj.get(3));
        System.out.println(obj.get(3));
        obj.addAtHead(1);
        obj.deleteAtIndex(4);
    }
}