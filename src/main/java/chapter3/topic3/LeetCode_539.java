package chapter3.topic3;

import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2022/01/18
 *
 * 539. 最小时间差
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 * 题意： 求最小值
 *
 * 思路： 先计算转换、再排序： 最小值在开头或者中间
 * 1. 排序
 * 2. 鸽巢原理: 一共有 24 * 60=1440 种不同的时间。由鸽巢原理可知，如果 timePoints > 1440，那么必然会有两个相同的时间，此时可以直接返回 0。
 *
 */
public class LeetCode_539 {

    // 鸽巢原理:
    public int findMinDifference2(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < n; ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    // Faster: 27.25%
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}
