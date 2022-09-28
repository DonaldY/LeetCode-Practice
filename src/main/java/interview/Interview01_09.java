package interview;

/**
 * @author donald
 * @date 2022/09/29
 *
 * 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 *
 * 示例2:
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 *
 * 思路：
 * 1. 暴力法： 取巧
 * 2. 手动模拟
 */
public class Interview01_09 {

    // 方法一： 暴力法
    // Time: O(n^2), Space: O(n), Faster: 100.00%
    public boolean isFlipedString(String s1, String s2) {
        if (null == s1) return false;
        if (null == s2) return false;
        if (s1.length() != s2.length()) return false;
        String s = s1 + s1;
        return s.contains(s2);
    }

    // 方法二： 暴力法， 手动模拟
    // Time: O(n^2), Space: O(n), Faster: 18.52%
    public boolean isFlipedStringByHand(String s1, String s2) {
        if (null == s1) return false;
        if (null == s2) return false;
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        for (int i = 0; i < s1.length(); ++i) {
            int start = i;
            boolean flag = true;
            for (int j = 0; j < s2.length(); ++j) {
                if (s1.charAt(start % s1.length()) != s2.charAt(j)) {
                    flag = false;
                    ++start;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
