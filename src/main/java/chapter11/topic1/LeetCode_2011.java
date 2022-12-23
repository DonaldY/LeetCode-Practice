package chapter11.topic1;

/**
 * @author donald
 * @date 2022/12/23
 */
public class LeetCode_2011 {

    // Time: O(n), Space: O(1), Faster: 63.58
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if ("X++".equals(op) || "++X".equals(op)) {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
