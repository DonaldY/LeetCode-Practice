package chapter3.topic1;

/**
 * @author donald
 * @date 2021/10/13
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i if non of the above conditions are true.
 *  
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 * Example 2:
 *
 * Input: n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 * Example 3:
 *
 * Input: n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * 思路：
 * 1. 直接判断输出
 * 2.
 */
public class LeetCode_412 {

    // Time: O(n), Space: O(1), Faster: 39.58%
    public List<String> fizzBuzz(int n) {

        int i = 0;
        List<String> result = new ArrayList<>(n);
        while (i++ < n) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i  % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0 ) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }
        return result;
    }

    public List<String> fizzBuzz2(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String cur = "";
            if (i % 3 == 0) cur += "Fizz";
            if (i % 5 == 0) cur += "Buzz";
            if (cur.length() == 0) cur = i + "";
            ans.add(cur);
        }
        return ans;
    }
}
