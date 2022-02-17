package chapter9.topic4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/02/18
 *
 * 1791. 找出星型图的中心节点
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。
 * 请你找出并返回 edges 所表示星型图的中心节点。
 *
 *
 * 示例 1：
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 *
 *
 * 示例 2：
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 *
 *
 * 题意： 找中心点
 *
 * 思路： 中心点必与每个节点相连
 * 1. 暴力法： 遍历一遍求最大值
 * 2. 只比较两个节点就行： 寻找出现在两条边中的节点
 */
public class LeetCode_1791 {

    // Time: O(n), Space: O(n), Faster: 10.63%
    public int findCenter(int[][] edges) {

        if (null == edges || edges.length == 0) return -1;

        Map<Integer, Integer> map = new HashMap<>(edges.length);

        int ans = 0, max = 0;

        for (int [] edge : edges) {

            map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
            map.put(edge[1], map.getOrDefault(edge[1], 1) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (max < entry.getValue()) {

                ans = entry.getKey();
                max = entry.getValue();
            }
        }

        return ans;
    }

    // Time: O(1), Space: O(1), Faster: 100.00%
    public int findCenter1(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
