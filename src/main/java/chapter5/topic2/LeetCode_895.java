package chapter5.topic2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author donald
 * @date 2022/11/30
 */
public class LeetCode_895 {


}

// Faster: 95.1%
class FreqStack {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> cnts = new HashMap<>();
    int max;
    public void push(int val) {
        cnts.put(val, cnts.getOrDefault(val, 0) + 1);
        int c = cnts.get(val);
        List<Integer> list = map.getOrDefault(c, new ArrayList<>());
        list.add(val);
        map.put(c, list);
        max = Math.max(max, c);
    }
    public int pop() {
        List<Integer> list = map.get(max);
        int ans = list.remove(list.size() - 1);
        cnts.put(ans, cnts.get(ans) - 1);
        if (list.size() == 0) max--;
        return ans;
    }
}