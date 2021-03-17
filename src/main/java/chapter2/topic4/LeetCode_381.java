package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2021/03/17
 *
 * LeetCode 381. Insert Delete GetRandom O(1) - Duplicates allowed
 *
 *
 * 题意：这个题目说的是，你要设计一个增加版的集合（Collection），它要支持以下操作：插入元素（insert）、删除元素（remove）以及随机获取元素（getRandom）。
 *
 * 注意，这 3 个操作的平均时间复杂度都要求是 O(1)。另外，这个集合中允许存储重复元素，一个元素被随机返回的概率与它在集合中的数量正相关。
 *
 * 难点在于：
 * 1. 操作时间复杂度为 0(1)
 * 2. 每个数随机
 * 3. 解决冲突，一般使用拉链法
 *
 * 思路：
 * 方法一：
 *    1. HashMap 存储值， key 为 值， value 为 HashSet 解决冲突， value 存储下标
 *    2. 随机： 将所有的数均放到一个 list 中，取的时候随机 random
 */
public class LeetCode_381 {

    // Faster: 86.03%
    public class RandomizedCollection {

        private final Map<Integer, Set<Integer>> map = new HashMap<>();
        private final List<Integer> data = new ArrayList<>();
        private final Random RANDOM = new Random();

        // 新增操作
        public boolean insert(int val) {
            boolean existed = map.containsKey(val);
            if (!existed) map.put(val, new HashSet<>());
            data.add(val);
            map.get(val).add(data.size()-1);
            return !existed;
        }

        // 移除操作
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val).iterator().next();
            map.get(val).remove(idx);
            int lastIdx = data.size() - 1;
            // 解决删除后，数组移动，所有均删除最后一个
            // 最后一个不是要删除的值，则先交换位置
            if (idx != lastIdx) {
                int lastVal = data.get(lastIdx);
                data.set(idx, lastVal);
                map.get(lastVal).remove(lastIdx);
                map.get(lastVal).add(idx);
            }
            data.remove(lastIdx);
            if (map.get(val).isEmpty()) map.remove(val);
            return true;
        }

        // 获取随机数
        public int getRandom() {
            int idx = RANDOM.nextInt(data.size());
            return data.get(idx);
        }
    }

    // Faster: 98.62%
    public class RandomizedCollectionV2 {

        class Pair<F, S> {
            public F first;
            public S second;
            Pair(F first, S second) {
                this.first = first;
                this.second = second;
            }
        }

        private final Map<Integer, List<Integer>> map = new HashMap<>();
        private final List<Pair<Integer, Integer>> data = new ArrayList<>();
        private final Random RANDOM = new Random();

        public boolean insert(int val) {
            boolean existed = map.containsKey(val);
            if (!existed) map.put(val, new ArrayList<>());
            data.add(new Pair<>(val, map.get(val).size()));
            map.get(val).add(data.size()-1);
            return !existed;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            List<Integer> indexes = map.get(val);
            int idx = indexes.remove(indexes.size()-1);
            int lastIdx = data.size() - 1;
            if (idx != lastIdx) {
                Pair<Integer, Integer> lastPair = data.get(lastIdx);
                int lastVal = lastPair.first;
                int lastValPosInMap = lastPair.second;
                data.set(idx, lastPair);
                map.get(lastVal).set(lastValPosInMap, idx);
            }
            data.remove(lastIdx);
            if (map.get(val).isEmpty()) map.remove(val);
            return true;
        }

        public int getRandom() {
            int idx = RANDOM.nextInt(data.size());
            return data.get(idx).first;
        }
    }
}
