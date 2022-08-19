package chapter1.topic4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author donald
 * @date 2022/08/19
 *
 * 设计一个类求和为给定值的两个数
 *
 * 这个题目说的是，你要设计一个支持 add 操作和 find 操作的类。其中，add 操作添加一个整数到这个类的内部数据结构；而 find 操作则是检查内部数据结构中是否存在求和等于给定值的两个数。
 *
 * 比如说，一开始添加 3 个数字：
 *
 * add(1)
 * add(2)
 * add(3)
 *
 * 你可以用 find 检查内部数据结构中是否存在两个数字相加等于 4 或 6：
 *
 * find(4) => true
 * find(6) => false
 *
 *
 *
 */
public class LeetCode_170 {
    public class TwoSumIIIList {

        private List<Integer> data = new ArrayList<>();

        // Time: O(1)
        public void add(int number) {
            data.add(number);
        }

        // Time: O(n)
        public boolean find(int value) {
            Set<Integer> set = new HashSet<>();
            for (int num: data) {
                if (set.contains(value - num)) return true;
                set.add(num);
            }
            return false;
        }
    }

    public class TwoSumIIIO1Find {

        private List<Integer> data = new ArrayList<>();
        private Set<Integer> sumSet = new HashSet<>();

        // Time: O(n)
        public void add(int number) {
            for (int num: data)
                sumSet.add(num + number);
            data.add(number);
        }

        // Time: O(1)
        public boolean find(int value) {
            return sumSet.contains(value);
        }
    }
}
