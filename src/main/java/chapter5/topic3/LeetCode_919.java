package chapter5.topic3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/10/13
 */
public class LeetCode_919 {
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

// Faster: 99.83%
class CBTInserter {

    private TreeNode root;
    private List<TreeNode> data;
    public CBTInserter(TreeNode root) {
        this.root = root;
        data = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                data.add(node);
                if (null != node.left) queue.add(node.left);
                if (null != node.right) queue.add(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        data.add(node);
        // 找父节点：完全二叉树，倍数关系
        TreeNode root = data.get(data.size() / 2 - 1);
        // 与父节点构建关系
        if (null == root.left) root.left = node;
        else root.right = node;

        return root.val;
    }

    public TreeNode get_root() {
        return root;
    }
}