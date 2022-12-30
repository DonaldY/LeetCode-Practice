package chapter11.topic1;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/12/31
 */
public class LeetCode_2037 {

    // 思路：排序
    // Time: O(n ^ 2), Space: O(1), Faster: 97.41%
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }
}
