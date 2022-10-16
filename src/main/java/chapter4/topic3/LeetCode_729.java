package chapter4.topic3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author donald
 * @date 2022/10/14
 */
public class LeetCode_729 {
}

// 方法一： 暴力法, 直接遍历
class MyCalendar {

    private List<int[]> schedules;
    public MyCalendar() {
        this.schedules = new ArrayList<>();
    }

    // Time: O(n), Faster: 34.29%
    public boolean book(int start, int end) {
        for (int[] schedule : this.schedules) {
            // [s1, e1) 和 [s2, e2), 要没有交集：
            // s1 >= e2 或者 s2 >= e1  ==> s1 < e2 && s2 < e1
            if (schedule[0] < end && start < schedule[1]) {
                return false;
            }
        }
        schedules.add(new int[] {start, end});
        return true;
    }
}

// 方法二： 二分查找
class MyCalendar2 {

    private TreeSet<int[]> schedules;
    public MyCalendar2() {
        this.schedules = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    // Time: O(logn), Faster: 48.75%
    public boolean book(int start, int end) {
        if (this.schedules.isEmpty()) {
            schedules.add(new int[] {start, end});
            return true;
        }
        int[] tmp = {end, 0};
        int[] arr = schedules.ceiling(tmp);
        int[] prev = arr == null ? schedules.last() : schedules.lower(arr);
        if (arr == schedules.first() || schedules.lower(tmp)[1] <= start) {
            schedules.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}