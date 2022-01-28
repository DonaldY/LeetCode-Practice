package chapter10.topic4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author donald
 * @date 2022/01/28
 *
 * 1996. 游戏中弱角色的数量
 *
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，
 * 其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 *
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。
 * 更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 * 返回 弱角色 的数量。
 *
 * 示例 1：
 * 输入：properties = [[5,5],[6,3],[3,6]]
 * 输出：0
 * 解释：不存在攻击和防御都严格高于其他角色的角色。
 *
 *
 * 示例 2：
 * 输入：properties = [[2,2],[3,3]]
 * 输出：1
 * 解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 *
 *
 * 示例 3：
 * 输入：properties = [[1,5],[10,4],[4,3]]
 * 输出：1
 * 解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 *  
 *
 * 题意： 求数量
 *       其实就是求逆序对，上升到2维数组罢了
 *
 * 思路：
 * 1. 暴力法： 1各个比较
 * 2. 先排序，再逐个比较
 */
public class LeetCode_1996 {

    // Time: O(nlogn), Space: O(1), Faster: 91.94%
    public int numberOfWeakCharacters(int[][] properties) {

        // [1,3],[1,2],[4,5],[3,7]
        // --->
        // [4,5],[3,7],[1,2],[1,3]
        Arrays.sort(properties, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int cnt = 0;
        int maxDef = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                cnt++;
            } else {
                maxDef = p[1];
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1,3},{1,2},{4,5},{3,7}};

        Arrays.sort(nums, (a, b) ->
                a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        for(int i=0;i<nums.length; i++){
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
