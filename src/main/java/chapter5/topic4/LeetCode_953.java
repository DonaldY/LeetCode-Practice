package chapter5.topic4;

/**
 * @author donald
 * @date 2022/10/12
 *
 * 题意： 比较前后两个字符串大小，大小根据 `order` 列表判断
 *
 * 思路： 哈希表，字符表
 */
public class LeetCode_953 {

    public static void main(String[] args) {

        LeetCode_953 leetCode_953 = new LeetCode_953();
        // ["kuvp","q"]
        //"ngxlkthsjuoqcpavbfdermiywz"
        //["hello","leetcode"]
        //"hlabcdefgijkmnopqrstuvwxyz"
        System.out.println(leetCode_953.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    // Time: O(n*m), Space: O(1), Faster: 100.00%
    public boolean isAlienSorted(String[] words, String order) {

        // 哈希表： 每个字符对应下标
        int[] map = new int[26];
        for (int i = 0; i < order.length(); ++i) map[order.charAt(i) - 'a'] = i;

        for (int i = 1; i < words.length; ++i) {

            String preStr = words[i - 1];
            String cur = words[i];
            boolean flag = false;
            for (int j = 0; j < preStr.length() && j < cur.length(); ++j) {
                int idx1 = preStr.charAt(j) - 'a';
                int idx2 = cur.charAt(j) - 'a';
                if (map[idx1] > map[idx2]) return false;      // 字符顺序小，错误
                else if (map[idx1] == map[idx2]) flag = true; // 字符相等
                else {                                        // 字符顺序大，正确
                    flag = false;
                    break;
                }
            }
            if (flag && preStr.length() > cur.length()) { // 短字符串也是错
                return false;
            }
        }

        return true;
    }
}
