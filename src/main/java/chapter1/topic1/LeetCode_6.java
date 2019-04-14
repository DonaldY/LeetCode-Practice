package chapter1.topic1;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 6 : ZigZag Conversion
 *
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

    public String convert(String s, int numRows) {

        char [] arr = s.toCharArray();

        List<List<Character>> outputLists = new ArrayList<List<Character>>(numRows);

        for (int i = 0; i < numRows; ++i) {

            outputLists.add(new ArrayList<Character>());
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
}
