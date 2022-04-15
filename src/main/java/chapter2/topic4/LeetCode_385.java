package chapter2.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2022/04/15
 * <p>
 * 385. 迷你语法分析器
 * <p>
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
 * <p>
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "324",
 * 输出：324
 * 解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 示例 2：
 * <p>
 * 输入：s = "[123,[456,[789]]]",
 * 输出：[123,[456,[789]]]
 * 解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * i.  一个 integer 包含值 456
 * ii. 一个包含一个元素的嵌套列表
 * a. 一个 integer 包含值 789
 * <p>
 * 题意： 模拟题
 * <p>
 * 思路： 模拟
 */
public class LeetCode_385 {

    static NestedInteger ph = new NestedInteger(0);
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> d = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        int n = cs.length, i = 0;
        while (i < n) {
            if (cs[i] == ',' && ++i >= 0) continue;
            if (cs[i] == '-' || (cs[i] >= '0' && cs[i] <= '9')) {
                int j = cs[i] == '-' ? i + 1 : i, num = 0;
                while (j < n && (cs[j] >= '0' && cs[j] <= '9')) num = num * 10 + (cs[j++] - '0');
                d.addLast(new NestedInteger(cs[i] == '-' ? -num : num));
                i = j;
            } else if (cs[i] == '[') {
                d.addLast(new NestedInteger());
                d.addLast(ph);
                i++;
            } else {
                List<NestedInteger> list = new ArrayList<>();
                while (!d.isEmpty()) {
                    NestedInteger poll = d.pollLast();
                    if (poll == ph) break;
                    list.add(poll);
                }
                for (int j = list.size() - 1; j >= 0; j--) d.peekLast().add(list.get(j));
                i++;
            }
        }
        return d.peekLast();
    }

}

class NestedInteger {

    public NestedInteger() {}
    public NestedInteger(Integer a) {}

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger() {return false;}

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger() {return 0;}

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value) {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni) {}

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList() {return Collections.emptyList();}

}
