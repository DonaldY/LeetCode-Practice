package chapter8.topic4;

/**
 * @author donald
 * @date 2023/3/10
 */
public class LeetCode_1590 {

    public int minSubarray(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            if (index.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - index.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }

}
