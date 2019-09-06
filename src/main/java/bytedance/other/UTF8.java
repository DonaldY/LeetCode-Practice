package bytedance.other;

/**
 * 拓展练习 - UTF-8 编码验证
 *
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 *
 * 示例 1:
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2:
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 *
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 * 题意: 比对
 *
 * 思路: 直接比对
 */
public class UTF8 {

    // Time: o(n), Space: o(1)
    public boolean validUtf8(int[] data) {

        int cnt = 0;

        for (int num : data) {

            if (cnt == 0) {
                if ((num >> 5) == 0b110) cnt = 1;
                else if ((num >> 4) == 0b1110) cnt = 2;
                else if ((num >> 3) == 0b11110) cnt = 3;
                else if ((num >> 7) > 0) return false;
            } else {

                if ((num >> 6) != 0b10) return false;
                --cnt;
            }
        }

        return cnt == 0;
    }
}
