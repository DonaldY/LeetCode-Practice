package chapter1.topic1;

/**
 * LeetCode 5 LongestPalindromicSubstring
 *
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 *
 */
public class LeetCode_5 {

    public static void main(String[] args) {

        LeetCode_5 longestPalindromicSubstring = new LeetCode_5();

        System.out.println(longestPalindromicSubstring.longestPalindrome(""));

        /*char [] arr = "bccb".toCharArray();

        System.out.println(longestPalindromicSubstring.isPalindromic(arr, 0 ,3));*/
    }

    public String longestPalindrome(String s) {

        if (s.length() == 0) {

            return "";
        }

        char [] arr = s.toCharArray();

        int length = 0;
        int start = 0;
        int end = 0;

        for (int i = 0 ; i < arr.length - 1; ++i) {

            for (int j = arr.length - 1; j > 0; --j) {

                if (isPalindromic(arr, i, j)) {

                    if (length < (j - i + 1)) {

                        length = j - i + 1;
                        start = i;
                        end = j;
                    }
                }

            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <= end; ++i) {

            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }

    private boolean isPalindromic(char[] arr, int start, int end) {

        int len = (end - start + 1) / 2;

        for (int i = start, j = end; i < start + len && j > end - len; ++i, --j) {

            if (arr[i] != arr[j]) {

                return false;
            }
        }

        return true;
    }
}
