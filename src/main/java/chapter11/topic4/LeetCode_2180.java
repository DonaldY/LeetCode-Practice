package chapter11.topic4;

/**
 * @author donald
 * @date 2023/01/06
 */
public class LeetCode_2180 {

    int[] odd = new int[] {1, 3, 5, 7, 9};
    int[] even = new int[] {0, 2, 4, 6, 8};
    // 暴力法： 偶数与偶数、奇数与奇数
    // Time: O(n*logn), Space: O(1), Faster: 83.12%
    public int countEven(int num) {
        if (num <= 0) return 0;

        int ans = 0;
        for (int i = 2; i <= num; ++i) {
            if (isEven(i)) ++ans;
        }
        return ans;
    }

    private boolean isEven(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum % 2 == 0;
    }
}
