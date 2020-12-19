package chapter3.topic4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2020/12/19
 *
 * Leetcode 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 思路：
 * 1. 递归
 * 2. 栈
 */
public class LeetCode_589 {

    // Time: O(n), Space: O(1), Faster: 92.81%
    public List<Integer> preorder(Node root) {
        if (null == root) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        traver(root, result);
        return result;
    }

    private void traver(Node root, List<Integer>  result) {

        if (null == root || null == root.children) return;

        result.add(root.val);

        for (Node node : root.children) {

            traver(node, result);
        }
    }
}
