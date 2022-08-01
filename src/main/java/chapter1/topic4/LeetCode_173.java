package chapter1.topic4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author donald
 * @date 2021/03/28
 *
 * LeetCode： 二叉搜索树迭代器
 *
 * 这个题目说的是，给你一棵二叉搜索树，你要为它实现一个迭代器。
 * 迭代器中包含两个公有方法，next() 方法返回二叉搜索树中下一个最小的数字，hasNext() 方法返回是否还存在下一个数字。
 *
 * 注意，next() 方法和 hasNext() 方法都要求平均时间复杂度是 O(1)，并且额外只能使用 O(h) 的辅助空间。
 * 其中，h 是二叉搜索树的高度。另外，你可以假设对 next() 方法的调用总是有效的，即不需要考虑在 next() 方法中处理不存在下一个数字的情况。
 *
 *
 * ```
 * 比如说，给你的二叉搜索树 t 是：
 *
 * t:
 *     1
 *   /   \
 *  0     4
 *       / \
 *      2   8
 *
 * 用 t 初始化迭代器，然后就可以调用 next() 和 hasNext()：
 *
 * BSTIterator it = new BSTIterator(t);
 * it.next();    //  0
 * it.next();    //  1
 * it.next();    //  2
 * it.hasNext(); // true
 * it.next();    //  4
 * it.next();    //  8
 * it.hasNext(); // false
 * ```
 *
 * 思路：
 * 1. 暴力法： 先全部计算好，中序排序
 * 2. 辅助栈：
 */
public class LeetCode_173 {

    public class BSTIterator {

        private final Stack<TreeNode> stack = new Stack<>();

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        // T(avg): O(1), S(avg): O(h)
        public int next() {
            TreeNode node = stack.pop();
            pushLeft(node.right);
            return node.val;
        }

        // T(avg): O(1), S(avg): O(h)
        public boolean hasNext() {
            return stack.size() != 0;
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}