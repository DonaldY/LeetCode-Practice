package chapter7.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2023/02/23
 */
public class LeetCode_1238 {

    // Time: O(2^n), Space: O(1), Faster: 73.91%
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ret = new ArrayList<>();
        ret.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(((ret.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ret;
    }
}
