package chapter1.topic3;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 146. LRU Cache
 *
 * 题意：
 *
 * 思路：
 * 1. 新元素进入栈顶，栈底元素退出
 *    若栈中已经存在新元素，则把新元素放入栈顶
 */
public class LeetCode_146 {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

class Node {

    private int key;
    private int value;

    Node(int key, int value) {

        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key;
    }

    @Override
    public int hashCode() {
        return key;
    }
}

// Time: o(n), Space: o(n), Faster: 5.06%
class LRUCache {

    private Queue<Node> queue;

    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public int get(int key) {

        Node node = this.contains(key);

        if (node != null) {

            queue.remove(node);
            queue.add(node);
            return node.getValue();
        }

        return -1;
    }

    private Node contains(int key) {

        return this.queue.stream().filter(node -> node.getKey() == key).findFirst().orElse(null);
    }

    public void put(int key, int value) {

        Node node = new Node(key, value);

        if (this.queue.contains(node)) {

            queue.remove(node);
            queue.add(node);
            return;
        }

        if (queue.size() == capacity) {

            queue.remove();
        }

        queue.add(node);
    }
}

