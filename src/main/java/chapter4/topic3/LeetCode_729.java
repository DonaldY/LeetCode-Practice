package chapter4.topic3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/10/14
 */
public class LeetCode_729 {
}

// 方法一： 暴力法
class MyCalendar {

    private List<int[]> schedules;
    public MyCalendar() {
        this.schedules = new ArrayList<>();
    }

    // Time: O(n), Faster: 34.29%
    public boolean book(int start, int end) {
        for (int[] schedule : this.schedules) {
            if (schedule[0] < end && start < schedule[1]) {
                return false;
            }
        }
        schedules.add(new int[] {start, end});
        return true;
    }
}