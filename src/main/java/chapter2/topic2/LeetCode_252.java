package chapter2.topic2;

import java.util.List;

/**
 * @author donald
 * @date 2022/08/18
 *
 * 这个题目说的是，给你一系列的会议时间区间，每个时间区间由开始时间和结束时间构成。你要判断出同一个人是否可以参加所有会议。
 *
 * 比如说，给你两个时间区间：
 *
 * [2, 4]
 * [4, 6]
 *
 * 这两个时间区间没有重叠，因此所有会议都能参加，返回 true。
 *
 * 如果再增加一个会议，得到三个时间区间：
 *
 * [2, 4]
 * [4, 6]
 * [1, 3]
 *
 * 由于 [1, 3] 和 [2, 4] 在时间上有重叠，因此同一个人不可能参加所有会议，返回 false。
 *
 * 思路： 排个序，再逐个与下一个比较
 */
public class LeetCode_252 {

    public class Interval {
        int start;
        int end;
        Interval(int s, int e) { start = s; end = e; }
    }

    // Time: O(n*log(n)), Space: O(1)
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        for (int i = 0; i < intervals.size()-1; ++i) {
            if (intervals.get(i).end > intervals.get(i+1).start) {
                return false;
            }
        }
        return true;
    }
}
