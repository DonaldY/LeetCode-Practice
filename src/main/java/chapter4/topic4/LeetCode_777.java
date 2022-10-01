package chapter4.topic4;


import java.util.Arrays;

/**
 * @author donald
 * @date 2022/10/02
 *
 * 777. 在LR字符串中交换相邻字符
 *
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 *
 *  
 * 示例 :
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 *  
 *
 * 题意： 字符变换
 *
 * XL -> LX, RX -> XR
 *
 * 题目的意思是说 R 只能向右移动，并且只能移向 X， L 只能向左移动，并且只能移向 X。
 *
 * 思路： 双指针 left、right
 * 1. 把 X 去掉， 判断 start 和 end 字符串
 *
 *
 *
 * 题后感： 一开是看不懂题， 以为只是简单的转换，醉了。
 *         以为还要 DFS 下， 实际上看规律
 */
public class LeetCode_777 {

    public static void main(String[] args) {

        LeetCode_777 leetCode_777 = new LeetCode_777();
        System.out.println(leetCode_777.canTransform("RXXLRXRXL", "XRLXXRRLX"));


    }

    // Time: O(n), Space: O(1), Faster: 54.32%
    public boolean canTransform(String start, String end) {
        if (!(start.replace("X", "").equals(end.replace("X", "")))) {
            return false;
        }
        for (int left = 0, right = 0; left < start.length(); ++left) {
            if (start.charAt(left) == 'X') continue;
            while (end.charAt(right) == 'X') ++right;
            if (left != right && (start.charAt(left) == 'L') == left < right) return false;
            ++right;
        }
        return true;
    }
}
