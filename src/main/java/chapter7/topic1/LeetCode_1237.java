package chapter7.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2023/02/18
 */
public class LeetCode_1237 {

    // Faster: 7.56%
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            for (int y = 1; y <= 1000; y++) {
                if (customfunction.f(x, y) == z) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(x);
                    pair.add(y);
                    res.add(pair);
                }
            }
        }
        return res;
    }
}

class CustomFunction {

    public int f(int x, int y) {
        return 0;
    }
}