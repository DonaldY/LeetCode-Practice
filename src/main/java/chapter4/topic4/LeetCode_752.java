package chapter4.topic4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author donald
 * @date 2022/08/08
 *
 * 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 *
 *
 * 思路：
 * 1. BFS
 * 2. 双向 BFS
 */
public class LeetCode_752 {
    // Time: O(b^d * d^2 + md), Space: O(b^d * d^2 + md), Faster: 15.30%
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动 BFS
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String cur = q.poll();

                // 判断密码是否合法
                if (deads.contains(cur)) {
                    continue;
                }
                if (target.equals(cur)) {
                    return step;
                }

                for (int j = 0; j < 4; ++j) {
                    String up = plusOne(cur, j); // 向下拨， 0 -> 1
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j); // 向上拨， 0 -> 9
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            ++step; // 增加步数
        }
        // 穷举完了，没有找到目标
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    // Time: O(b^d * d^2 + md), Space: O(b^d * d^2 + md), Faster: 84.26%
    public int openLockBFS2(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        // 从起点开始启动 BFS
        int step = 0;
        // 初始化起点和终点
        q1.add("0000");
        q2.add(target);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 在遍历的过程不能修改哈希集合
            // 用 temp 存储 q1的扩散结果
            Set<String> temp = new HashSet<>();

            // 将 q1 中的所有节点向周围扩散
            for (String cur : q1) {
                // 判断密码是否合法
                if (deads.contains(cur)) {
                    continue;
                }
                if (q2.contains(cur)) {
                    return step;
                }
                visited.add(cur);

                for (int j = 0; j < 4; ++j) {
                    String up = plusOne(cur, j); // 向下拨， 0 -> 1
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    String down = minusOne(cur, j); // 向上拨， 0 -> 9
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }
            }
            ++step; // 增加步数
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        // 穷举完了，没有找到目标
        return -1;
    }
}
