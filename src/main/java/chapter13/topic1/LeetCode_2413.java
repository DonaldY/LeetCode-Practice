package chapter13.topic1;

/**
 * @author donald
 * @date 2023/04/21
 */
public class LeetCode_2413 {

    // Time: O(1), Space: O(1), Faster: 100%
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
