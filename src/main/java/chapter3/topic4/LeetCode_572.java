package chapter3.topic4;

import java.util.HashMap;
import java.util.Map;

/**
 * 572. Subtree of Another Tree
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 * 题意： 给两个树 s 和 t， 判断 t 是否为 s的子树
 *
 * 思路：
 * 1. 先在 s树中找到 t的头节点，然后再相同递归查找
 * 2. s 的子树一颗颗拿出来比较
 * 3. 为每一颗子树做唯一标识
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_572 {

    // Time: O(m*n), Space: O(h), Faster: 92.95%
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val &&
                isSameTree(s.left, t.left) &&
                isSameTree(s.right, t.right);
    }

    private Map<TreeNode, Integer> map = new HashMap<>();


    // Time: O(m+n), Space: O(m+n), Faster: 7.77%
    public boolean isSubtreeHash(TreeNode s, TreeNode t) {
        computeHash(s);
        computeHash(t);
        return isSub(s, t);
    }

    private String computeHash(TreeNode t) {
        if (t == null) return "#";
        String left = computeHash(t.left);
        String right = computeHash(t.right);
        String hash = left + t.val + right;
        map.put(t, hash.hashCode());
        return hash;
    }

    private boolean isSub(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return map.get(s).equals(map.get(t)) || isSub(s.left, t) || isSub(s.right, t);
    }
}
