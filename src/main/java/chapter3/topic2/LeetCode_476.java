package chapter3.topic2;

/**
 * @author donald
 * @date 2021/10/18
 */

/**
 *
 *
 * 思路：
 * 1. 模拟：遍历一次
 * 2. 模拟： lowbit
 */
public class LeetCode_476 {

    // Time: O(logn), Space: O(1), Faster: 100%
    public int findComplement(int num) {
        int s = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                s = i;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < s; i++) {
            if (((num >> i) & 1) == 0) ans |= (1 << i);
        }
        return ans;
    }

    // Time: O(logn), Space: O(1), Faster: 100%
    public int findComplement2(int num) {
        int x = 0;
        for (int i = num; i != 0; i -= i & -i) x = i;
        return ~num & (x - 1);
    }
}
