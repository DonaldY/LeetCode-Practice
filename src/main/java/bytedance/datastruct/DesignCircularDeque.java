package bytedance.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2020/11/26
 *
 * Leetcode 641. 设计循环双端队列
 *
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 * isEmpty()：检查双端队列是否为空。
 * isFull()：检查双端队列是否满了。
 * 示例：
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			                   // 返回 true
 * circularDeque.insertLast(2);			                   // 返回 true
 * circularDeque.insertFront(3);			               // 返回 true
 * circularDeque.insertFront(4);			               // 已经满了，返回 false
 * circularDeque.getRear();  				               // 返回 2
 * circularDeque.isFull();				                   // 返回 true
 * circularDeque.deleteLast();			                   // 返回 true
 * circularDeque.insertFront(4);			               // 返回 true
 * circularDeque.getFront();				               // 返回 4
 *  
 *
 * 思路：
 * 浪费一个位置是指：循环数组中任何时刻一定至少有一个位置不存放有效元素。
 *   1. 判别队列为空的条件是：front == rear;；
 *   2. 判别队列为满的条件是：(rear + 1) % capacity == front;。
 *      可以这样理解，当 rear 循环到数组的前面，要从后面追上 front，还差一格的时候，判定队列为满。
 *
 * 因为有循环的出现，要特别注意处理数组下标可能越界的情况。
 *   1. 指针后移的时候，索引 + 1，要取模；
 *   2. 指针前移的时候，为了循环到数组的末尾，需要先加上数组的长度，然后再对数组长度取模。
 *
 * front 始终指向当前队首元素的位置
 * rear 始终指向当前队尾的下一个位置，也就是下一个入队元素的位置
 */
public class DesignCircularDeque {

    public static void main(String[] args) {

        //["getFront","getRear","getFront","getFront","getRear","insertLast"]
        //[,[],[],[],[],[],[0]]

        MyCircularDeque obj = new MyCircularDeque(2);
        boolean param_1 = obj.insertFront(7);
        boolean param_4 = obj.deleteLast();
        int param1 = obj.getFront();
        obj.insertLast(5);
        obj.insertFront(0);
        int param2 = obj.getFront();
        int param3 = obj.getRear();
        int param4 = obj.getFront();
        int param5 = obj.getFront();
        int param6 = obj.getRear();

        obj.insertLast(0);
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();
        System.out.println();
    }
}

// Faster: 68.14%
class MyCircularDeque {

    // 头部指向第 1 个存放元素的位置
    // 插入时，先减，再赋值
    // 删除时，索引 +1（注意取模）
    private int head = 0;
    // 尾部指向下一个插入元素的位置
    // 插入时，先赋值，再加
    // 删除时，索引 -1（注意取模）
    private int tail = 0;
    private int[] arr;
    private int capacity;

    public MyCircularDeque(int k) {

        this.capacity = k + 1;
        this.arr = new int[this.capacity];
    }

    public boolean insertFront(int value) {

        if (isFull()) return false;

        head = (head - 1 + capacity) % capacity;

        arr[head] = value;

        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) return false;

        arr[tail] = value;

        tail = (tail + 1) % capacity;

        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) return false;

        head = (head + 1) % capacity;

        return true;
    }

    public boolean deleteLast() {

        if (isEmpty()) return false;

        tail = (tail - 1 + capacity) % capacity;

        return true;
    }

    public int getFront() {

        if (isEmpty()) return -1;

        return arr[head];
    }

    public int getRear() {

       if (isEmpty()) return -1;

       return arr[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {

       return head == tail;
    }

    public boolean isFull() {

        return (tail + 1) % capacity == head;
    }
}