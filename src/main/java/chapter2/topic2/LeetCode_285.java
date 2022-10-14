package chapter2.topic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/10/14
 *
 * 题意： 找给定值的第一个后继节点
 *
 * 思路：
 * 1. 先排序到列表，在列表中查找
 * 2. 利用二叉搜索树特性，遍历的时候查找
 * 3. 暴力法： 直接搜索整个树（略）
 */
public class LeetCode_285 {

    public static void main(String[] args) {

        LeetCode_285 leetCode_285 = new LeetCode_285();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        leetCode_285.inorderSuccessorIterator(root, root.left);
    }

    // 方法一： 排序、查找
    // Time: O(n), Space: O(n), Faster: 34.42%
    public TreeNode inorderSuccessorSort(TreeNode root, TreeNode p) {
        if (null == root) return null;
        List<TreeNode> list = new ArrayList<>();

        // 1. sort
        inorder(root, list);

        // 2. 查找
        int idx = 0;
        for (; idx < list.size(); ++idx) {
            if (list.get(idx).val >= p.val) break; // 找到 p 这个数
        }
        if (idx + 1 >= list.size()) return null; // p 的后继节点不存 || p 不存在
        return list.get(idx + 1);
    }
    // 树的中序遍历
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (null == root) return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    // 方法二： 查找: p 节点的右节点的最小左节点
    // Time: O(n), Space: O(1), Faster: 100.00%
    public TreeNode inorderSuccessorIterator(TreeNode root, TreeNode p) {
        if (null == root) return null;
        // 1. p 的右节点存在
        if (null != p.right) {
            TreeNode result = null;
            // 一直找其右节点的左节点
            for (TreeNode cur = p.right; null != cur; cur = cur.left) {
                result = cur;
            }
            return result;
        }

        // 2. p 的右节点不存在， 只能找到其父节点
        TreeNode result = null;
        for (TreeNode cur = root; null != cur;) {
            if (cur.val > p.val) {
                result = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        return result;
    }
}
