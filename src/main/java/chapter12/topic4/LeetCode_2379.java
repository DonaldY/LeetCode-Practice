package chapter12.topic4;

/**
 * @author donald
 * @date 2023/03/09
 */
public class LeetCode_2379 {
    // Time: O(n), Space: O(1), Faster: 58.27%
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, cnt = 0;
        while (r < k) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }
        int res = cnt;
        while (r < blocks.length()) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
            res = Math.min(res, cnt);
            l++;
            r++;
        }
        return res;
    }
}
