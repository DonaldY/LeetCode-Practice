package bytedance.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 挑战字符串 - 复原IP地址
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 题意：给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 根据局限性 0 ～ 255， 总位数不得 > 12， 每一位至少有一个数字
 *
 * 思路：
 * 将所有分割均列举出来，再筛选
 * 1. for循环 3层
 * 2. dfs
 */
public class RestoreIpAddresses {

    // Time:
    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() > 12 || s.length() < 4) return Collections.emptyList();

        List<String> result = new ArrayList<>();

        findValidIp(s, "", 1, result);

        return result;
    }

    private void findValidIp(String restStr, String str, int cnt, List<String> result) {

        if (cnt == 4 && isValid(restStr)) {

            result.add(str + restStr);

            return;
        }

        for (int i = 1; i < Math.min(4, restStr.length()); ++i) {

            String currStr = restStr.substring(0, i);

            if (isValid(currStr)) {

                findValidIp(restStr.substring(i), str + currStr + ".", cnt + 1, result);
            }
        }

    }

    private boolean isValid(String str) {

        if (str == null || str.length() == 0) {

            return false;
        }

        if (str.charAt(0) == '0') {

            return "0".equals(str);
        }

        int num = Integer.parseInt(str);

        return num > 0 && num < 256;
    }
}
