package chapter8.topic3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2023/03/03
 */
public class LeetCode_1487 {

    // Time: 42.24%
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}
