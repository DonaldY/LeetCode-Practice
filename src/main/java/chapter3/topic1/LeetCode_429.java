package chapter3.topic1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author donald
 * @date 2020/12/19
 *
 * Leetcode 429. N 叉树的层序遍历
 *
 *  给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 *
 * 思路：
 * 1. 用队列来模拟
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

public class LeetCode_429 {

    // Time: O(n), Space:O(n), Faster: 82.95%
    public List<List<Integer>> levelOrder(Node root) {

        if (null == root) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);

        int num = 1;

        while (!queue.isEmpty()) {

            int temp = 0;

            List<Integer> tempList = new ArrayList<>(num);

            for (int i = 0; i < num; ++i) {

                Node node = queue.poll();

                tempList.add(node.val);

                if (null == node.children) continue;

                for (Node tmpNode : node.children) {

                    ++temp;
                    queue.add(tmpNode);
                }
            }

            result.add(tempList);

            num = temp;
        }

        return result;
    }
}
