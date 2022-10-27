package chapter10;

/**
 * @author donald
 * @date 2022/10/27
 *
 * 思路： 简单模拟题
 */
public class LeetCode_1822 {

    public int arraySign(int[] nums) {
        int ans = 1;
        for (int x : nums) {
            if (x == 0) return 0;
            if (x < 0) ans *= -1;
        }
        return ans;
    }
}
