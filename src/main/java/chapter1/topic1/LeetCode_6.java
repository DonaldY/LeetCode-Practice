package chapter1.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6 : ZigZag Conversion
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 */
public class LeetCode_6 {

    public static void main(String[] args) {

        LeetCode_6 leetCode6 = new LeetCode_6();

        System.out.println(leetCode6.convert("PAYPALISHIRING", 3));
        // LCIRETOESIIGEDHN
        // "PAHNAPLSIIGYIR"
        // PINALSIGYAHRPI
    }

    // Faster: 38.97%
    public String convert(String s, int numRows) {

        char [] arr = s.toCharArray();

        List<List<Character>> outputLists = new ArrayList<List<Character>>(numRows);

        for (int i = 0; i < numRows; ++i) {

            outputLists.add(new ArrayList<>());
        }

        int index = 0;

        int arrow = 1;

        for (char anArr : arr) {

            outputLists.get(index).add(anArr);

            if (index == numRows - 1) {

                arrow = (arrow + 1) % 2;
            } else if (index == 0) {

                arrow = (arrow + 1) % 2;
            }

            if (arrow == 0 && index < numRows - 1) {

                ++index;
            }

            if (arrow == 1 && index > 0) {

                --index;
            }
        }

        StringBuilder outputStr = new StringBuilder();

        for (List<Character> outputList : outputLists) {

            for (Character anOutputList : outputList) {

                outputStr.append(anOutputList);
            }
        }

        return outputStr.toString();
    }

    public String convert2 (String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
