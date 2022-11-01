package chapter9.topic2;

/**
 * @author donald
 * @date 2022/11/01
 *
 * 1662. 检查两个字符串数组是否相等
 *
 *
 */
public class LeetCode_1662 {

    // Time: O(n), Space: O(n), Faster: 100.00%
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String str : word1) sb1.append(str);
        for (String str : word2) sb2.append(str);

        return sb1.toString().equals(sb2.toString());
    }
}
