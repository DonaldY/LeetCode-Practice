package chapter9.topic4;

/**
 * @author donald
 * @date 2022/12/17
 */
public class LeetCode_1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }
}
