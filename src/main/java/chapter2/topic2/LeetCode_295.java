package chapter2.topic2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2020/5/11
 *
 * 295. Find Median from Data Stream
 *
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 *
 * 题意：
 * 模拟操作，求出中位数，如果是偶数则求和再除以2
 *
 * 思路：
 * 1. 暴力法，加入数据后排好序
 * 2. 堆
 *
 */
public class LeetCode_295 {


    // Time: O(n ^ 2), Space: O(n), Faster: 8.39%
    List<Integer> datas = new ArrayList<>();
    public void addNum(int num) {

        int ids = datas.size() - 1;

        while (ids >= 0 && num < datas.get(ids)) --ids;

        datas.add(ids + 1, num);
    }

    public double findMedian() {

        int size = datas.size();

        // 0 1 2 3
        if (size % 2 == 0) {

            int middle = size / 2;

            return (datas.get(middle) + datas.get(middle - 1)) / 2.0;
        }

        return datas.get(size / 2);
    }
}
