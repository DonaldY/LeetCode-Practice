package chapter3.topic4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2020/12/19
 *
 * Leetcode 590. N叉树的后序遍历
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 * 思路：
 * 1. 递归（树的后续遍历）
 * 2. 迭代方式，栈
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class LeetCode_590 {

    // Time: O(n), Space: O(1), Faster: 100.00%
    public List<Integer> postorder(Node root) {

        if (null == root) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        traver(root, result);
        return result;
    }

    private void traver(Node root, List<Integer>  result) {

        if (null == root || null == root.children) return;

        for (Node node : root.children) {

            traver(node, result);
        }

        result.add(root.val);
    }
}
