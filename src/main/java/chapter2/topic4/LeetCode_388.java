package chapter2.topic4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author donald
 * @date 2022/04/20
 */
public class LeetCode_388 {
    public int lengthLongestPath(String s) {
        Map<Integer, String> map = new HashMap<>();
        int n = s.length();
        String ans = null;
        for (int i = 0; i < n; ) {
            int level = 0;
            while (i < n && s.charAt(i) == '\t' && ++level >= 0) i++;
            int j = i;
            boolean isDir = true;
            while (j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') isDir = false;
            }
            String cur = s.substring(i, j);
            String prev = map.getOrDefault(level - 1, null);
            String path = prev == null ? cur : prev + "/" + cur;
            if (isDir) map.put(level, path);
            else if (ans == null || path.length() > ans.length()) ans = path;
            i = j + 1;
        }
        return ans == null ? 0 : ans.length();
    }
}
