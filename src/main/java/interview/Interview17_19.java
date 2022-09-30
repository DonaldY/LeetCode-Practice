package interview;

import java.util.Arrays;

/**
 * @author donald
 * @date 2022/09/26
 *
 * 面试题 17.19. 消失的两个数字
 *
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 *
 * 示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 *
 * Tips： 数组无序
 *
 * 思路：
 * 1. 暴力法： 排序后， 1个个查即可
 * 2. 等差数列求和
 * 3. 位运算： 异或取技巧
 */
public class Interview17_19 {
    public static void main(String[] args) {
        /*Interview17_19 interview1719 = new Interview17_19();

        System.out.println(Arrays.toString(interview1719.missingTwo(new int[]{2,3})));*/

        int xor = 5;
        int diff = xor & -xor;
        System.out.println(Integer.toBinaryString(xor));
        System.out.println(Integer.toBinaryString(-xor));
        System.out.println(Integer.toBinaryString(diff));
    }
    // 方法一： 暴力法
    // Time: O(nlogn), Space: O(1), Faster: 16.17%
    public int[] missingTwo(int[] nums) {
        if (null == nums || nums.length == 0) return new int[] {1, 2};
        Arrays.sort(nums);
        int cur = 1, index = 0;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length;) {
            if (index == 2) return ans;
            if (cur == nums[i]) {
                ++i;
            } else {
                ans[index++] = cur;
            }
            ++cur;
        }
        while (index < 2) {
            ans[index++] = cur;
            cur ++;
        }
        return ans;
    }

    // 方法二：等差数列求和
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int[] missingTwo2(int[] nums) {
        // 1. 求完整数的和： 等差数列求和
        int n = nums.length + 2; // 2 是缺少的数，补上
        int sum = (1 + n) * n / 2;

        // 2. 实际的和
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        // 3. 两个缺失数之和
        int needSum = sum - actualSum;
        int mid = needSum / 2; // 分界线

        // 4. 求其中缺失的一个数
        int halfSum = 0;
        for (int num : nums) {
            if (num <= mid) halfSum += num;
        }
        int ans = (1 + mid) * mid / 2 - halfSum;
        return new int[] {ans, needSum - ans};
    }

    // 方法三：位运算
    // Time: O(n), Space: O(1), Faster: 100.00%
    public int[] missingTwo3(int[] nums) {
        int n = nums.length + 2;
        int res = 0;
        // 1. 求缺失两数的异或值：相同两数异或为 0
        for (int i = 1; i <= n; i++) res ^= i;
        for (int i : nums) res ^= i;

        // 2. 求最低位的 1
        int diff = res & -res;
        int o = 0;
        // 3. 先求其中一个缺失的数，一组数异或
        for (int i = 1; i <= n; i++) {
            if ((diff & i) != 0) o ^= i;
        }
        // 4 再利用相同两数异或为 0，求得其中一个缺失的数
        for (int i : nums) {
            if ((diff & i) != 0) o ^= i;
        }
        return new int[] {o, o ^ res};
    }
}
