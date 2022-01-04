package chapter6.topic4;

/**
 * @author donald
 * @date 2022/01/03
 *
 * 1185. 一周中的第几天
 *
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 示例 1：
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 *
 * 示例 2：
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 *
 * 示例 3：
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * 题意： 算时间
 *
 * 思路：
 * 通过查询日历可知，1970 年 12 月 31 日是星期四，需要算出输入的日期距离 1970 年 12 月 31 日有几天，
 * 再加上 3 后对 7 求余，即可得到输入日期是一周中的第几天。
 *
 * 求输入的日期距离 1970 年 12 月 31 日的天数，可以分为三部分分别计算后求和：
 * （1）输入年份之前的年份的天数贡献；
 * （2）输入年份中，输入月份之前的月份的天数贡献；
 * （3）输入月份中的天数贡献。
 *
 * 例如，如果输入是 2100 年 12 月 31 日，即可分为三部分分别计算后求和：
 * （1）1971 年 11 月 11 日到 2099 年 12 月 31 日之间所有的天数；
 * （2）2100 年 11 月 11 日到 2100 年 11 月 31 日之间所有的天数；
 * （3）2100 年 12 月 11 日到 2100 年 12 月 31 日之间所有的天数。
 *
 */
public class LeetCode_1185 {

    public String dayOfTheWeek(int day, int month, int year) {

        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        /* 输入年份之前的年份的天数贡献 */
        // 同时计算润年
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        /* 输入年份中，输入月份之前的月份的天数贡献 */
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        /* 输入月份中的天数贡献 */
        days += day;
        return week[(days + 3) % 7];
    }
}
