package chapter9.topic3;

/**
 * @author donald
 * @date 2022/11/11
 */
public class LeetCode_1704 {

    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2);
        String h = "aeiouAEIOU";
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            if (h.indexOf(a.charAt(i)) >= 0) {
                sum1++;
            }
        }
        for (int i = 0; i < b.length(); i++) {
            if (h.indexOf(b.charAt(i)) >= 0) {
                sum2++;
            }
        }
        return sum1 == sum2;
    }
}
