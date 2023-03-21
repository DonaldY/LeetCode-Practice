package chapter13.topic2;

/**
 * @author donald
 * @date 2023/03/21
 */
public class LeetCode_2469 {

    // 思路：直接模拟
    // Time: O(1), Space: O(1), Faster: 100%
    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
