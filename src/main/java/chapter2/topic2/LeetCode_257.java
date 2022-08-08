package chapter2.topic2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2022/08/09
 *
 * 二叉树中的所有路径
 *
 * 这个题目说的是，给你一棵二叉树，你要返回所有**从根到叶子节点**的路径。
 *
 * # 比如说，给你的二叉树是：
 *    1
 *  /   \
 * 2     4
 *  \
 *   8
 *
 * # 在这棵二叉树中，从根到叶子节点有两条路径：
 * [
 *  "1->2->8",
 *  "1->4"
 * ]
 *
 * 思路： DFS （回溯）
 */
public class LeetCode_257 {
    // Time: O(n^2), Space: O(n^2), Faster: 32.55%
    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        dfs(result, root, "");
        return result;
    }

    private void dfs(List<String> result, TreeNode root, String path) {
        if (null == root) {
            return;
        }

        if ("".equals(path)) {
            path += root.val;
        } else {
            path += "->" + root.val;
        }

        if (null == root.left && null == root.right) {
            result.add(path);
            return;
        }

        dfs(result, root.left, path);
        dfs(result, root.right, path);
    }

    // Time: O(n*log(n)), Space: O(n), Faster: 99.97%
    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfsV2(root, new StringBuilder(), result);
        return result;
    }

    private void dfsV2(TreeNode root, StringBuilder path, List<String> result) {
        if (root == null) return;
        int len = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            result.add(path.toString());
        } else {
            path.append("->");
            dfsV2(root.left, path, result);
            dfsV2(root.right, path, result);
        }
        path.setLength(len);
    }
}
