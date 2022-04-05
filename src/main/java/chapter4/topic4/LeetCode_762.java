package chapter4.topic4;

/**
 * @author donald
 * @date 2022/04/05
 */
public class LeetCode_762 {

    static boolean[] hash = new boolean[40];
    static {
        int[] nums = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int x : nums) hash[x] = true;
    }
    // Faster: 57.08%
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int x = i, cnt = 0;
            while (x != 0 && ++cnt >= 0) x -= (x & -x);
            if (hash[cnt]) ans++;
        }
        return ans;
    }
}
