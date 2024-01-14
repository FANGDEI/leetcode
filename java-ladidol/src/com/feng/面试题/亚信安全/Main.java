package com.feng.面试题.亚信安全;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/27 19:28
 * @description: {}
 */
public class Main {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 找到小于或等于n的最大的幸运数。幸运数定义为仅由 3 和 7 组成的数。例如，37 和 773 都是幸运数，而 47 则不是。
     *
     * @param num int整型 一个正整数,4<=N<=10^9
     * @return int整型
     */
    public int maxLuckyNum(int num) {
        // write code here
        for (int i = num; i >= 3; i--) {
            if (check(i)) {
                return ans;
            }
        }
        return ans;
    }

    int ans;

    boolean check(int num) {
        int tmp = num;
        while (num != 0) {
            int mod = num % 10;
            if (mod == 7 || mod == 3) {
                num /= 10;
            } else {
//                System.out.println("mod = " + mod);
                return false;
            }

        }
        ans = tmp;
        return true;
    }


    public int getMaxCount(String[] pos) {
        // write code here
        int ans = 0;
        for (int i = 0; i < pos.length; ) {
            int count = 0;
            while (i < pos.length && pos[i].equals("B")) {
                count++;
                i++;
            }
            if (count <= 2) {
                i++;
                continue;
            }
            count -= 2;
            ans += (count + 1) / 2;
        }
        return ans;
    }

//    public int getMaxCount(String[] pos) {
//        // write code here
//        int ans = 0;
//        for (int i = 0; i < pos.length; i++) {
//            if (pos[i].equals("B")) {
//                if ((i == 0 || pos[i - 1].equals("B")) && (i == pos.length - 1 || pos[i + 1].equals("B"))) {
//                    ans++;
//                    pos[i] = "A";
//                }
//            }
//
//        }
//        return ans;
//    }


    /**
     * 买卖股票，固定交易次数问题
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // write code here
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];//第一次
        dp[0][3] = -prices[0];//第二次
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);//卖出
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);//第二次卖出

        }

        return dp[prices.length - 1][4];
    }


}