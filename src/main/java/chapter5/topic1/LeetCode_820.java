package chapter5.topic1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author donald
 * @date 2022/10/19
 *
 * 思路：
 * 1. 暴力法： 每一个比较， endWith
 */
public class LeetCode_820 {

    public static void main(String[] args) {

        LeetCode_820 leetCode_820 = new LeetCode_820();
        leetCode_820.minimumLengthEncoding(new String[] {"time", "me", "bell"});
    }

    // 方法一： 暴力法，排序 + 对比
    // Time: O(n*m), Space: O(n), Faster: 5.05%
    public int minimumLengthEncoding(String[] words) {
        if (null == words || words.length == 0) return 0;

        // 1. 以长度大小 降序
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        // 2. 需要多少个字符串
        List<String> strList = new ArrayList<>(words.length);
        for (String str : words) {
            boolean flag = true;
            if (strList.isEmpty()) strList.add(str);
            for (String word : strList) {
                if (word.endsWith(str)) { // 是否有这个后缀
                    flag = false;
                    break;
                }
            }
            if (flag) {
                strList.add(str);
            }
        }

        // 3. 求字符串长度
        int len = 0;
        for (String str : strList) {
            len += str.length();
        }

        return len + strList.size(); // +上需要多少个 #
    }
}
