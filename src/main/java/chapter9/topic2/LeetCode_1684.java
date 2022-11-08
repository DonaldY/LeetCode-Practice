package chapter9.topic2;

/**
 * @author donald
 * @date 2022/11/08
 */
public class LeetCode_1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] arr = new boolean[26];
        for (char c : allowed.toCharArray()) arr[c - 'a'] = true;
        int ans = 0;
        for (String s : words) {
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (!arr[c - 'a']) {
                    flag = true;
                    break;
                }
            }
            if (!flag) ans++;
        }
        return ans;
    }
}
