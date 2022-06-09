package chapter2.topic2;

/**
 * @author donald
 * @date 2020/5/3
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * <p>
 * 题意：
 * 将二叉树转换为字符串，字符串再转为二叉树
 * <p>
 * 思路：
 * 二叉树 => 字符串
 * 1. BFS 队列形式转换,然后转换为数组
 * <p>
 * 字符串 => 二叉树
 * 1. 按下标 ×2,来生成
 */
public class LeetCode_297 {

    // Encodes a tree to a single string.
    // Time: O(n), Space: O(n), Faster: 66.63%
    public String serialize(TreeNode root) {

        if (root == null) return "[]";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder result = new StringBuilder("[");

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (null == node) {

                result.append("null");
            } else {

                result.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }

            if (queue.isEmpty()) {

                break;
            }

            result.append(",");
        }

        result.append("]");

        return result.toString();
    }

    // Decodes your encoded data to tree.
    // Time: O(n), Space: O(n)
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        // 去掉前后的 [], 再分割元素
        String[] elems = data.substring(1, data.length() - 1).split(",");
        // 1. 存储树节点
        TreeNode[] trees = new TreeNode[elems.length];
        // 2. 创建树节点
        for (int i = 0; i < elems.length; ++i)
            trees[i] = elems[i].equals("null") ? null : new TreeNode(Integer.valueOf(elems[i]));
        // 3. 构造树节点关系
        int i = 1;
        for (TreeNode tree : trees) {
            if (tree != null) {
                if (i < trees.length) tree.left = trees[i++];
                if (i < trees.length) tree.right = trees[i++];
            }
        }
        return trees[0];
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
