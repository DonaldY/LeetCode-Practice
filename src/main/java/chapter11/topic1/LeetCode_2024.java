package chapter11.topic1;

/**
 * @author donald
 * @date 2022/03/29
 */
public class LeetCode_2024 {

    String s;
    int n, k;
    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        n = s.length(); k = _k;
        return Math.max(getCnt('T'), getCnt('F'));
    }
    int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
