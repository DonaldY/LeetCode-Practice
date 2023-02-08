package chapter7.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author donald
 * @date 2023/02/08
 */
public class LeetCode_1233 {

    // Time: O(nl logn), Space: O(l), Faster: 48.52%
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int pre = ans.get(ans.size() - 1).length();
            if (!(pre < folder[i].length() && ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) && folder[i].charAt(pre) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }
}
