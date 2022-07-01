package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-01-13:09
 * <p>
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 */
@SuppressWarnings("all")
public class L551学生出勤记录I {
    public static void main(String[] args) {

    }

    /**
     * 条件判断 模拟 一次遍历
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        //初始化A和L的出现的此处 这里的lates用于存储L连续出现的次数
        int absents = 0, lates = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absents++;
                //如果A出现次数大于2了 那么就直接返回false
                if (absents >= 2) {
                    return false;
                }
            }
            //如果出现L
            if (c == 'L') {
                //L连续出现的次数加一
                lates++;
                //如果累计大于等于三次了直接返回false
                if (lates >= 3) {
                    return false;
                }
                //如果下一个不是L 那么L连续出现的次数清零
            } else {
                lates = 0;
            }
        }
        //符合条件返回true
        return true;
    }
}
