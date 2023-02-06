package chapter12.topic3;

/**
 * @author donald
 * @date 2023/02/06
 */
public class LeetCode_2331 {

    // 递归：
    // Time: O(n), Space: O(n), Faster:
    public boolean evaluateTree(TreeNode root) {
        if (null == root.left) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
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
