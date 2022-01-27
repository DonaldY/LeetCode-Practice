package chapter11.topic1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author donald
 * @date 2022/01/26
 *
 * 2013. 检测正方形
 *
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 *
 * 添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * 给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 *
 *
 */
public class LeetCode_2013 {


}

// Faster: 82.41%
class DetectSquares {

    // {x, {y : 点 (x,y) 数量}}
    Map<Integer, Map<Integer, Integer>> cnt;

    public DetectSquares() {
        cnt = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> yCnt = cnt.get(y);
        yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!cnt.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> yCnt = cnt.get(y);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
            int col = entry.getKey();
            Map<Integer, Integer> colCnt = entry.getValue();
            if (col != y) {
                // 根据对称性，这里可以不用取绝对值
                int d = col - y;
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
            }
        }
        return res;
    }
}
