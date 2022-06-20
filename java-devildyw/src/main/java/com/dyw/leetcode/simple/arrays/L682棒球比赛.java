package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;

/**
 * @author Devil
 * @date 2022-05-24-13:05
 *
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 */
@SuppressWarnings("all")
public class L682棒球比赛 {
    public static void main(String[] args) {
        System.out.println(new L682棒球比赛().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    /**
     * 变长数组模拟链表
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        ArrayList<Integer> result = new ArrayList<>();
        int res = 0;
        for (String op : ops) {
            int n = result.size();
            switch (op.charAt(0)){
                case '+':
                    int sum = Integer.valueOf(result.get(n - 1)) + Integer.valueOf(result.get(n - 2));
                    res += sum;
                    result.add(sum);
                    break;
                case 'C':
                    res-=result.get(n-1);
                    result.remove(n-1);
                    break;
                case 'D':
                    int m = result.get(n - 1) * 2;
                    res+=m;
                    result.add(m);
                    break;
                default:
                    Integer num = Integer.valueOf(op);
                    res += num;
                    result.add(num);
                    break;
            }
        }
        return res;
    }
}
