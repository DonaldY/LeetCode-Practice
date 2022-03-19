package chapter4.topic1;

/**
 * @author donald
 * @date 2022/03/19
 *
 * 606. 根据二叉树创建字符串
 *
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 示例 1:
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * 题意： 遍历打印
 *
 * 思路： 前序遍历
 * 1. 判断是否子节点，有子节点则加上 (
 * 2. 结束了，子节点加上 )
 */
public class LeetCode_606 {

    // Faster: 100.00%
    public String tree2str(TreeNode root) {
        if (null == root) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if (null == root.left && null != root.right) {
            sb.append("()");
        } else {
            printStr(root.left, sb);
        }
        printStr(root.right, sb);

        return sb.toString();
    }

    private void printStr(TreeNode root, StringBuilder sb) {
        if (null == root) return;
        sb.append("(");
        sb.append(root.val);

        if (null == root.left && null != root.right) {
            sb.append("()");
        } else {
            printStr(root.left, sb);
        }
        printStr(root.right, sb);

        sb.append(")");
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


