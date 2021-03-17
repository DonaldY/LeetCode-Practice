package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2021/03/16
 *
 * LeetCode 380. Insert Delete GetRandom O(1)
 *
 * Implement the RandomizedSet class:
 *
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * Follow up: Could you implement the functions of the class with each function works in average O(1) time?
 *
 *
 * ```
 * Example 1:
 *
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 *
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 * ```
 *
 * 题意：这个题目说的是，你要设计一个增加版的集合（Set），
 * 它除了支持插入元素（insert）和删除元素（remove）的操作，
 * 还能等概率地随机获取当前集合中的元素（getRandom）。
 * 并且这 3 个操作的平均时间复杂度都要求是 O(1)。
 *
 * 思路：
 * 哈希表 + 顺序表
 * data: [a,b,c, ...]
 * key value
 * a    0
 * b    1
 * c    2
 * ...
 *
 */

public class LeetCode_380 {
}

// Faster: 82.04%
class RandomizedSet {

    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> data = new ArrayList<>();
    private final Random RANDOM = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        data.add(val);
        map.put(val, data.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastVal = data.get(data.size()-1);
        data.set(idx, lastVal);
        data.remove(data.size()-1);
        map.put(lastVal, idx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = RANDOM.nextInt(data.size());
        return data.get(idx);
    }
}
