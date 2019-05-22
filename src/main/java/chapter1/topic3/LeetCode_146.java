package chapter1.topic3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

class LRUCache {

    private int size;

    public LRUCache(int capacity) {

        this.size = capacity;

    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {


    }
}

