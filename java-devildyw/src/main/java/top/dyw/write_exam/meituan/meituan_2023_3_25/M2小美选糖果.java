package top.dyw.write_exam.meituan.meituan_2023_3_25;

import java.util.Scanner;

/**
 * @author Devildyw
 * @date 2023/03/25 19:20
 **/

/**
 * 题目描述：
 * 题目描述：
 * 小美因乐于助人的突出表现获得了老师的嘉奖。老师允许小美从一堆n个编号分别为1,2,...,n的糖果中选择任意多个糖果作为奖励（每种编号的糖果各一个），
 * 但为了防止小美一次吃太多糖果有害身体健康，老师设定了一个限制：如果选择了编号为 i 的糖果，那么就不能选择编号为 i-1, i-2, i+1, i+2的四个糖果了。
 * 在小美看来，每个糖果都有一个对应的美味值，小美想让她选出的糖果的美味值之和最大！作为小美的好朋友，请你帮帮她！
 *
 *
 * 输入描述
 * 第一行一个整数n，表示糖果数量。
 *
 * 第二行n个整数a1,a2,...,an，其中ai表示编号为 i 的糖果的美味值。
 *
 * 1≤n≤50000 , 1≤ai≤10000
 *
 * 输出描述：
 * 输出一行一个数，表示小美能获得的糖果美味值之和最大值。
 *
 * 样例输入
 * 7
 * 3 1 2 7 10 2 4
 *
 * 样例输出
 * 14
 *
 * 提示：
 * 最优的方案是选择编号为1，4，7的糖果。
 *
 * 如果选了编号为5的美味值为10的那颗糖果，最多能获得的美味值仅为13，不如上述方案优。
 */
@SuppressWarnings("all")
public class M2小美选糖果 {

    /**
     * dp 这道 ac了
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = input.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = candy[0];
        dp[2] = Math.max(candy[0],candy[1]);
        //dp[i] =
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-3]+candy[i-1],dp[i-1]);
        }

        System.out.println(dp[n]);

    }
}
