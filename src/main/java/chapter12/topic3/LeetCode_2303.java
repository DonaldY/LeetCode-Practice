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
        for (int[] bracket : brackets) {
            if (income <= bracket[0]) {
                ans += (income - preTax) * 1.0 * bracket[1] / 100;
                break;
            }
            ans += (bracket[0] - preTax) * 1.0 * bracket[1] / 100;
            preTax = bracket[0];
        }

        return ans;
    }
}
