package bytedance.datastruct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 数据结构 - LRU缓存机制
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * LRUCache cache = new LRUCache(2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 * 题意: 模拟LRU
 *
 * 思路:
 * LRU 特征: 最少使用先出
 * 1. get 存在的元素会被添加到末尾
 * 2. add 元素均会被添加到末尾
 */
public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        // [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    private HashMap<Integer, Integer> map;

    private LinkedList<Integer> queue;

    private int capacity;

    public LRUCache(int capacity) {

        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public int get(int key) {

        Integer value = map.get(key);

        if (value == null) return -1;

        queue.remove((Integer) key);

        queue.addLast(key);

        return value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            map.put(key, value);
            queue.remove((Integer) key);
            queue.addLast(key);

            return;
        }

        if (queue.size() == capacity) {

            int _key = queue.removeFirst();
            map.remove(_key);
        }

        map.put(key, value);
        queue.addLast(key);
    }
}
