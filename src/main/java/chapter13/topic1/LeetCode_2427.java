package chapter13.topic1;

/**
 * @author donald
 * @date 2023/04/05
 */
public class LeetCode_2427 {

    public int commonFactors(int a, int b) {
        int ans = 0;
        for (int x = 1; x <= Math.min(a, b); ++x) {
            if (a % x == 0 && b % x == 0) {
                ++ans;
            }
        }
        return ans;
    }
}
