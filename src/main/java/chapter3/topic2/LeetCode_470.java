package chapter3.topic2;

import java.util.Random;

/**
 * 470. Implement Rand10() Using Rand7()
 *
 * Given a function rand7 which generates a uniform random integer in the range 1 to 7,
 * write a function rand10 which generates a uniform random integer in the range 1 to 10.
 *
 * Do NOT use system's Math.random().
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: [7]
 * Example 2:
 *
 * Input: 2
 * Output: [8,4]
 * Example 3:
 *
 * Input: 3
 * Output: [8,1,10]
 *
 *
 * Note:
 *
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is called.
 *
 * Tips：
 * 如果 x > y，那么一定可以用 randx 去实现 randy。其中：
 * randx 表示等概率生成 1 到 x的函数
 * randy 表示等概率生成 1 到 y的函数
 *
 * 题意： 用 rand7 实现 rand10
 *
 * 思路：
 * 1. 将 rand7 映射为 更高的（> 10）， 然后来实现 rand10
 */
public class LeetCode_470 {

    private final Random RANDOM = new Random();

    // generate integer in the range 1 to 7
    private int rand7() {
        return RANDOM.nextInt(7) + 1;
    }

    public int rand10() {
        int x = Integer.MAX_VALUE;
        while (x > 10)
            x = 7 * (rand7() - 1) + rand7();
        return x;
    }

    // Time:O(n), Space: O(1), Faster: 73.42%
    public int rand10Opt() {
        int x = Integer.MAX_VALUE;
        while (x > 40)
            x = 7 * (rand7() - 1) + rand7();
        return x % 10 + 1;
    }
}
