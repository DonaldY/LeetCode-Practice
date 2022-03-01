package chapter3.topic4;

/**
 * @author donald
 * @date 2022/03/02
 *
 * 564. 寻找最近的回文数
 *
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: n = "123"
 * 输出: "121"
 * 示例 2:
 *
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 *
 */
public class LeetCode_564 {

    // Faster: 77.50%
    public String nearestPalindromic(String n) {
        int len = n.length();
        if (len == 1)  // 一位数的最近回文串就是它减1
            return (Integer.parseInt(n) - 1) + "";
        long org = Long.parseLong(n), thousand = (long) Math.pow(10, len - 1);
        if (org == thousand  || org == thousand + 1)  // org是10,100,1000,10000,..., 或 11,101,1001,10001,...
            return String.valueOf(thousand - 1);  // 返回9,99,999,9999,...
        thousand = thousand * 10L - 1L;
        if (org == thousand)  // org是99,999,9999,...
            return String.valueOf(thousand + 2L);  // 返回101,1001,10001,...
        // 特判结束，下面是普通数字。处理左半段后逆转填到右半段上
        int left = Integer.parseInt(n.substring(0, (len + 1) / 2));
        long ans = Long.MAX_VALUE, diff = Long.MAX_VALUE;
        for (int a : new int[] {1, 0, -1}) {  // 处理左半段：不变或加减1
            String lf = (left + a) + "";
            String full = new StringBuilder(len % 2 == 0 ? lf : lf.substring(0, lf.length() - 1))
                    .reverse().insert(0, lf).toString();
            if (n.equals(full))
                continue;
            long _full = Long.parseLong(full);
            if (Math.abs(_full - org) <= diff) {
                diff = Math.abs(_full - org);
                ans = Math.min(ans, _full);
            }
        }
        return ans + "";
    }
}
