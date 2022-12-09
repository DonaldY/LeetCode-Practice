package chapter9.topic4;

/**
 * @author donald
 * @date 2022/12/09
 */
public class LeetCode_1780 {
    // Time: O(logn), Space: O(1), Faster: 100%
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
