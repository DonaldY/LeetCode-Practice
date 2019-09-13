package bytedance.linkedlist;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 题意：遍历树
 *
 * 思路：
 * 1. BFS， 根据左右摇摆，
 */
public class ZigzagLevelOrder {

    // Time: o(n), Space: o(n)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        queue.add(root);

        boolean seq = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> tmpList = new ArrayList<>(size);

            for (; size > 0 && !queue.isEmpty(); --size) {

                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                tmpList.add(node.val);
            }

            if (!seq) {

                for (int i = 0; i < tmpList.size() / 2; ++i) {

                    int tmp = tmpList.get(i);
                    tmpList.set(i, tmpList.get(tmpList.size() - i - 1));
                    tmpList.set(tmpList.size() - i - 1, tmp);
                }
            }

            seq = !seq;

            result.add(tmpList);
        }

        return result;
    }
}
