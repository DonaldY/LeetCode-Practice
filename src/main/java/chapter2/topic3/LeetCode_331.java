package chapter2.topic3;

import java.util.Stack;

/**
 * @author donald
 * @date 2021/03/12
 *
 * LeetCode 331. 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * ```
 * 示例 1:
 *
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "1,#"
 * 输出: false
 *
 *
 * 示例 3:
 *
 * 输入: "9,#,#,1"
 * 输出: false
 * ```
 *
 * 题意：验证前序遍历是否正确
 *
 * 思路：
 * 1. 按照原字符串构造树，再前序遍历树输出前序字符串，然后两个字符串比较
 * 2. 用栈模拟
 * 3. 计数法
 */
public class LeetCode_331 {

    // Time: O(n), Space: O(n), Faster: 28.91%
    public boolean isValidSerializationWithStack(String preorder) {

        if (null == preorder || preorder.length() == 0) return false;

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 0; i < preorder.length(); ++i) {

            if (stack.isEmpty()) {
                return false;
            }

            if (preorder.charAt(i) == ',') continue;
            else if (preorder.charAt(i) == '#') {
                int slot = stack.pop();
                if (--slot > 0) stack.push(slot);
            } else {
                // 若数为 123, 需将数读完整
                while (i < preorder.length() && preorder.charAt(i) != ',') ++i;
                int slot = stack.pop();
                if (--slot > 0) stack.push(slot);
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    // Time: O(n), Space: O(1), Faster: 82.30%
    public boolean isValidSerialization(String preorder) {

        if (null == preorder || preorder.length() == 0) return false;

        int slot = 1;
        for (int i = 0; i < preorder.length(); ++i) {

            if (slot == 0) return false;
            if (preorder.charAt(i) == ',') continue;
            else if (preorder.charAt(i) == '#') {
                --slot;
            } else {
                while (i < preorder.length() && preorder.charAt(i) != ',') ++i;
                // 消耗自身，再添加两个子节点： -1 + 2 = 1
                ++slot;
            }
        }
        return slot == 0;
    }
}
