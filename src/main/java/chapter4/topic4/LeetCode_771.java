package chapter4.topic4;

/**
 * 771. Jewels and Stones
 *
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 * 题意： J 代表 珠宝， S 表示一堆石头，计算出 S 中宝石数量
 *
 * 思路：
 * 1. hash表
 * 2. 数组
 */
public class LeetCode_771 {

    // Time: O(n), Space: O(1), Faster: 93.38%
    public int numJewelsInStones(String J, String S) {

        if (J == null || J.length() == 0 || S == null || S.length() == 0) return 0;

        int [] a = new int[256];

        int result = 0;

        for (int i = 0; i < J.length(); ++i) {

            ++a[J.charAt(i)];
        }

        for (int i = 0; i < S.length(); ++i) {

            if (a[S.charAt(i)] > 0) ++result;
        }

        return result;
    }
}
