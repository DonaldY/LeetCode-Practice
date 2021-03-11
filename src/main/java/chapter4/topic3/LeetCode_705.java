package chapter4.topic3;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author donald
 * @date 2021/03/13
 *
 * LeetCode 705. 设计哈希集合
 *
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * - void add(key) 向哈希集合中插入值 key 。
 * - bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * - void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没
 *
 * ```
 * 示例：
 *
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 *
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * ```
 *
 * 题意： 手动创建 HashSet
 *
 * 思路：
 * 需要解决的问题：
 * 1. 寻址
 * 2. 解决冲突: 拉链法
 * 3. 扩容
 */
public class LeetCode_705 {


}

// Time: O(), Space: O(), Faster: 45.90%
class MyHashSet {

    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}

// Time: O(), Space: O(), Faster: 99.77%
class MyHashSet2 {

    long[] set;
    int mod = 64;

    /** Initialize your data structure here. */
    public MyHashSet2() {
        set = new long[15626];
    }

    public void add(int key) {
        int idx = key / mod;
        int move = key % mod;
        set[idx] |= (1L << move);
    }

    public void remove(int key) {
        int idx = key / mod;
        int move = key % mod;
        set[idx] &= (~(1L << move));
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = key / mod;
        int move = key % mod;
        return (set[idx] & (1L << move)) != 0;
    }
}