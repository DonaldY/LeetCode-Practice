package bytedance.datastruct;

import java.util.*;

/**
 * 数据结构 -  全 O(1) 的数据结构
 *
 * 实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。
 * 如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 *
 */

public class AllOne {

    class Node{
        String key;
        int val;
        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    HashMap<String, Node> map;
    PriorityQueue<Node> minQ;
    PriorityQueue<Node> maxQ;
    public AllOne() {
        map = new HashMap<String, Node>();
        minQ = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        maxQ = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return b.val - a.val;
            }
        });
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new Node(key, 1));
            Node node = map.get(key);
            minQ.add(node);
            maxQ.add(node);
        } else {
            Node node = map.get(key);
            minQ.remove(node);
            maxQ.remove(node);
            node.val++;
            map.put(key, node);
            minQ.add(node);
            maxQ.add(node);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.val == 1) {
                map.remove(key);
                minQ.remove(node);
                maxQ.remove(node);
            } else {
                minQ.remove(node);
                maxQ.remove(node);
                node.val--;
                map.put(key, node);
                minQ.add(node);
                maxQ.add(node);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return maxQ.isEmpty() ? "" : maxQ.peek().key;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return minQ.isEmpty() ? "" : minQ.peek().key;
    }
}
