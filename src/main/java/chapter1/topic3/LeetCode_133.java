package chapter1.topic3;

import java.util.*;

/**
 * 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 *
 *
 * Example:
 *
 *
 *
 * Input:
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 *
 * Explanation:
 * Node 1's value is 1, and it has two neighbors: Node 2 and 4.
 * Node 2's value is 2, and it has two neighbors: Node 1 and 3.
 * Node 3's value is 3, and it has two neighbors: Node 2 and 4.
 * Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 *
 * 题意： 深度拷贝 图
 *
 * 思路：
 * 1. 直接查找
 *    1. 遍历一遍拷贝所有节点, 利用对象引用特性
 *
 */
public class LeetCode_133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Time: o(n ^ 2), Space: o(n), Faster:46.15%
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Set<Node> set = new HashSet<>();

        traverseGraph(node, map, set);

        Set<Node> set2 = new HashSet<>();

        return traverseGraphReturnNode(node, map, set2);
    }

    private Node traverseGraphReturnNode(Node node, Map<Node, Node> map, Set<Node> set) {

        if (node == null) return null;

        Node result = map.get(node);

        if (set.contains(node)) return result;

        set.add(node);

        if (node.neighbors == null || node.neighbors.size() == 0) return result;

        List<Node> list = new ArrayList<>(node.neighbors.size());

        for (Node neighbor : node.neighbors) {

            Node tmp = traverseGraphReturnNode(neighbor, map, set);

            list.add(tmp);
        }

        result.neighbors = list;

        return result;
    }

    private void traverseGraph(Node node, Map<Node, Node> map, Set<Node> set) {

        if (node == null || set.contains(node)) return;

        Node tmp = new Node(node.val, new ArrayList<>());

        set.add(node);

        map.put(node, tmp);

        if (node.neighbors == null) return;

        for (Node n : node.neighbors) {

            traverseGraph(n, map, set);
        }
    }
}
