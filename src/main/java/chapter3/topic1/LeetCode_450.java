package chapter3.topic1;

/**
 * 450. Delete Node in a BST
 *
 * Example:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * Another valid answer is [5,2,6,null,4,null,7].
 *
 * 题意：
 * 在二叉搜索树中删除节点
 *
 * 思路：
 * 删除节点，需要注意是否有子节点。若有子节点，需要注意左旋和右旋
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LeetCode_450 {

    // Time: o(h), Space: o(h)
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode leftMax = root.left;
            while (leftMax.right != null) leftMax = leftMax.right;
            leftMax.right = root.right;
            root = root.left;
        }

        return root;
    }

}
