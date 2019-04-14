package chapter1.topic1;

public class LeetCode_7 {

    public static void main(String[] args) {

        LeetCode_7 leetCode = new LeetCode_7();

        System.out.println(leetCode.reverse(1534236469));
    }

    public int reverse(int x) {

        long result = 0;

        int t = Math.abs(x);

        int isFirst = 0;

        int temp = 0;

        while ( t > 0) {

            temp = t % 10;

            t /= 10;

            if (isFirst == 0 && temp == 0) {

                continue;
            }

            if (result * 10 > 2147483647) {

                return 0;
            }

            result = result * 10;

            result += temp;

            isFirst = 1;
        }

        if (x < 0) {

            result = -result;
        }

        return (int) result;
    }
}
