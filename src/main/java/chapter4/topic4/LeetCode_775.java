package chapter4.topic4;

/**
 * @author donald
 * @date 2022/11/16
 */
public class LeetCode_775 {
    int n;
    int[] tr;
    int lowbit(int x) {
        return x & -x;
    }
    void add(int x) {
        for (int i = x; i <= n; i += lowbit(i)) tr[i]++;
    }
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tr[i];
        return ans;
    }
    public boolean isIdealPermutation(int[] nums) {
        n = nums.length;
        tr = new int[n + 10];
        add(nums[0] + 1);
        int a = 0, b = 0;
        for (int i = 1; i < n; i++) {
            a += query(n) - query(nums[i] + 1);
            b += nums[i] < nums[i - 1] ? 1 : 0;
            add(nums[i] + 1);
        }
        return a == b;
    }
}
