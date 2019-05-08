package chapter1.topic2;

import java.util.*;

/**
 * 100. Same Tree
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 *
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 *
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 *
 * 题意： 比较两颗树的大小
 *
 * 方法：
 * 1. 转化为数组进行比较
 * 2. 递归比较
 *   - 递归
 *   - 栈
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_100 {

    public static void main(String[] args) {

        TreeNode root1 = initTree1();
        TreeNode root2 = initTree2();

        LeetCode_100 leetCode = new LeetCode_100();
        System.out.println(leetCode.isSameTree(root1, root2));
    }

    private static TreeNode initTree2() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        return root;
    }

    private static TreeNode initTree1() {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        return root;
    }

    // Time: o(n) Space: o(n) faster: 68%
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;

        List<Integer> pArr = getTreeArray(p);
        List<Integer> qArr = getTreeArray(q);

        if (pArr.isEmpty() || qArr.isEmpty() || pArr.size() != qArr.size()) {

            return false;
        }

        for (int i = 0; i < pArr.size(); ++i) {

            if (!pArr.get(i).equals(qArr.get(i))) {

                return false;
            }
        }

        return true;
    }

    private List<Integer> getTreeArray(TreeNode root) {

        if (root == null) return Collections.EMPTY_LIST;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> array = new ArrayList<Integer>();

        queue.offer(root);
        array.add(root.val);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node.left != null) {

                array.add(node.left.val);
                queue.offer(node.left);
            } else {

                array.add(-1);
            }

            if (node.right != null) {

                array.add(node.right.val);
                queue.offer(node.right);
            } else {

                array.add(-1);
            }
        }

        return array;
    }

    // Time: o(n) Space: o(n) faster: 100%
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {

        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        return q.val == p.val &&
                isSameTreeRecursive(p.left, q.left) &&
                isSameTreeRecursive(p.right, q.right);
    }

    // Time: o(n) Space: o(n) faster: 61.37%
    private boolean isSameTreeIterative(TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {

            TreeNode s = stack.pop();
            TreeNode t = stack.pop();

            if (s == null && t == null) continue;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;

            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }

        return true;
    }
}
