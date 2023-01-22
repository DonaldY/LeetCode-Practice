package chapter12.topic3;

/**
 * @author donald
 * @date 2023/01/23
 */
public class LeetCode_2303 {

    // 暴力法： 模拟运算
    // Time: O(n), Space: O(n), Faster: 100.00%
    public double calculateTax(int[][] brackets, int income) {
        int preTax = 0;
        double ans = 0;
        for (int i = 0; i < brackets.length; ++i) {
            if (income <= brackets[i][0]) {
                ans += (income - preTax) * 1.0 * brackets[i][1] / 100;
                break;
            }
            ans += (brackets[i][0] - preTax) * 1.0 * brackets[i][1] / 100;
            preTax = brackets[i][0];
        }

        return ans;
    }
}
