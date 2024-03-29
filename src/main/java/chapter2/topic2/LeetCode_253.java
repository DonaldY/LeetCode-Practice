package chapter2.topic2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author donald
 * @date 2022/08/21
 *
 * 需要的最少会议室数量
 *
 * 这个题目说的是，给你一系列的会议时间区间，每个时间区间由开始时间和结束时间构成。你要计算出开完这些会所需要的最少会议室数量。
 *
 * 比如说，给你两个时间区间：
 *
 * [2, 4]
 * [4, 6]
 *
 * 这两个时间区间没有重叠，只需要使用一个会议室，因此返回 1。
 *
 * 如果再增加一个会议，得到三个时间区间：
 *
 * [2, 4]
 * [4, 6]
 * [1, 3]
 *
 * 对于这 3 个会议，至少需要两个会议室。一种会议安排方式为：
 *
 * 会议室 1：[1, 3], [4, 6]
 * 会议室 2：[2, 4]
 *
 * 因此，需要的最少会议室数量是 2。
 *
 *
 * 思路：
 * 1. 暴力法： 先排序，再逐个比较
 * 2. 最小堆： 先排序，再逐个比较
 */
public class LeetCode_253 {

    public class Interval {
        int start;
        int end;
        Interval(int s, int e) { start = s; end = e; }
    }

    // 方法一：暴力法
    // Time: O(n^2), Space: O(n)
    public int minMeetingRoomsBruteForce(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        // 1. 先排序
        intervals.sort((a, b) -> a.start - b.start);
        List<Integer> ends = new ArrayList<>(); // 存储会议结束时间，每一个表示一个会议室
        for (Interval meeting : intervals) {
            int idx = 0;
            // 2. 找到合适的会议室
            while (idx < ends.size() && ends.get(idx) > meeting.start) {
                ++idx;
            }
            // 3. 更新会议室的结束时间
            if (idx == ends.size()) ends.add(meeting.end);
            else ends.set(idx, meeting.end);
        }
        return ends.size();
    }

    // 方法二： 最小堆
    // Time: O(n*log(n)), Space: O(n)
    public int minMeetingRoomsMinHeap(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        // 1. 先排序
        intervals.sort((a, b) -> a.start - b.start);
        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); ++i) {
            Interval meeting = intervals.get(i);
            // 2. 比较： 是否有合适的会议室
            if (minHeap.peek() <= meeting.start) minHeap.poll();
            minHeap.add(meeting.end);
        }
        return minHeap.size();
    }
}
