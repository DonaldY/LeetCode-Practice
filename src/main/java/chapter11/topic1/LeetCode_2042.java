package chapter11.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2023/01/03
 */
public class LeetCode_2042 {

    // 字符串比对、字符串转化
    // Time: O(n), Space: O(n), Faster: 89.21%
    public boolean areNumbersAscending(String s) {

        if (null == s || s.length() == 0) return false;

        char[] arr = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length;) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            while (i < arr.length && arr[i] <= '9' && arr[i] >= '0') {
                flag = true;
                sb.append(arr[i]);
                ++i;
            }
            if (flag) {
                list.add(Integer.parseInt(sb.toString()));
            }
            ++i;
        }

        for (int i = 1; i < list.size(); ++i) {

            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }
}
