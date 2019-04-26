package chapter1.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 *
 * Input: -121
 * Output: false
 *
 * Input: 121
 * Output: true
 *
 * Input: 10
 * Output: false
 */
public class LeetCode_9 {

    public static void main(String[] args) {

        LeetCode_9 leetCode_9 = new LeetCode_9();

        System.out.println(leetCode_9.isPalindrome(-121));
        System.out.println(leetCode_9.isPalindrome(121));
        System.out.println(leetCode_9.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {

            return false;
        }

        List<Integer> list = new ArrayList<Integer>();

        int temp = x;

        while (temp != 0) {

            list.add(temp % 10);

            temp /= 10;
        }

        for (int i = 0; i < list.size() / 2; ++i) {

            if (list.get(i) !=  list.get(list.size() - i - 1)) {

                return false;
            }
        }

        return true;
    }
}
