package com.feng.newline.dp.backage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.backage
 * @className: L279完全平方数
 * @author: Ladidol
 * @description: 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 示例1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * @date: 2022/8/31 14:50
 * @version: 1.0
 */
public class L279完全平方数 {

    // 朴素的做法容易TLE
    class Solution1 {
        // 给定了若干个数字，每个数字可以被使用无限次，求凑出目标值  所需要用到的是最少数字个数是多少。
        // dp[i][j]: 表示考虑前i个数字，恰好和为j的最小数字数量。
        // dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-k*list[i]]+k); 注意每一个角标的含义；
        public int numSquares(int n) {
            List<Integer> list = getSquareNumbers(n);//得到可能会用的平方数。
            int INF = n + 1;// 无效值；
            int[][] dp = new int[list.size() + 1][n + 1];
            //把除了dp[0][0]以外的值都设置为无效值n+1(后面会用到dp[i][j]的默认值，所以一点是不为零的默认值。)
            for (int[] ints : dp) {
                Arrays.fill(ints, INF);//默认全部最多都需要n个1来加，所以需要n个数，所以默认用n+1不可能的答案。
            }
            dp[0][0] = 0;
            for (int i = 1; i <= list.size(); i++) {
                int x = list.get(i - 1);// 考虑当前的平方数
                for (int j = 0; j <= n; j++) {
                    int no = dp[i - 1][j];
                    for (int k = 1; ; k++) {
                        if (k * x > j) break;
                        if (dp[i - 1][j - k * x] != n + 1) {// 能够选择 k 个 x 的前提是剩余的数字 j - k * x 也能被凑出
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * x] + k);
                        }
                    }
                    dp[i][j] = Math.min(no, dp[i][j]);
                }
            }
            return dp[list.size()][n];
        }

        public List<Integer> getSquareNumbers(int n) {//注意是平方数，不是平方根
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                list.add(i * i);
            }
            return list;
        }
    }


    // 将第一个数字情况单独考虑，优化一下复杂度。
    class Solution2 {
        public int numSquares(int n) {
            List<Integer> list = getSquareNumbers(n);
            int INF = n + 1;
            int[][] dp = new int[list.size()][n + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, INF);
            }

            // 处理第一个数的情况
            for (int j = 0; j <= n; j++) {
                int t = list.get(0);
                int k = j / t;
                if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                    dp[0][j] = k;
                } else { // 其余则为无效值
                    dp[0][j] = INF;
                }
            }
//            dp[0][0] = 0;//可以删除的
            for (int i = 1; i < list.size(); i++) {
                int x = list.get(i);
                for (int j = 0; j <= n; j++) {
                    int no = dp[i - 1][j];
                    for (int k = 1; ; k++) {
                        if (k * x > j) break;
                        if (dp[i - 1][j - k * x] != n + 1) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * x] + k);
                        }
                    }
                    dp[i][j] = Math.min(no, dp[i][j]);
                }
            }
            return dp[list.size() - 1][n];
        }

        public List<Integer> getSquareNumbers(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                list.add(i * i);
            }
            return list;
        }
    }


    // 一维dp
    class Solution3 {
        public int numSquares(int n) {
            int INF = n + 1;//无效值
            int[] dp = new int[n + 1];
            Arrays.fill(dp, INF);
            List<Integer> list = getSquareNumbers(n);
            dp[0] = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j <= n; j++) {
                    int no = dp[j];
                    int yes = j - list.get(i) >= 0 ? dp[j - list.get(i)] + 1 : INF;
                    dp[j] = Math.min(no, yes);
                }
            }
            return dp[n];
        }

        public List<Integer> getSquareNumbers(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                list.add(i * i);
            }
            return list;
        }
    }

    // 优化合并一下for循环:完全平方数和遍历一起进行。
    class Solution123 {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, 0x3f3f3f3f);
            dp[0] = 0;
            for (int t = 1; t * t <= n; t++) {
                int x = t * t;
                for (int j = x; j <= n; j++) {
                    dp[j] = Math.min(dp[j], dp[j - x] + 1);
                }
            }
            return dp[n];
        }
    }

    //动态规划
    class Solution1223453 { //2022年10月17日09:43:17再做
        /**
         * 参数：[n]
         * 返回值：int
         * 作者： ladidol
         * 描述：dp[i][j]：考虑前i个完全平方数，完全平方数和是j；
         * dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-k*nums[i]]+k)
         * 通过数学花间的得到：
         * dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j - nums.get(i)] + 1)
         * 然后可以通过i的降维：
         * dp[j] = Math.min(dp[j],dp[j - nums.get(i)] + 1)//优美的完全背包。
         */
        public int numSquares(int n) {
            List<Integer> nums = getSquares(n);
            int[] dp = new int[n + 1];
            int INF = n + 1;//不可到达的数字。
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int i = 0; i < nums.size(); i++) {//从前i个数字开始考虑。
                for (int j = 0; j <= n; j++) {
                    int no = dp[j];
                    int yes = INF;
                    if (nums.get(i) < j)
                        yes = dp[j - nums.get(i)] + 1;//背包问题也：这里是通过数学化简的到的也。
                    dp[j] = Math.min(no, yes);
                }
            }
            return dp[n];
        }

        List<Integer> getSquares(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {//真就是这样写的捏。
                list.add(i * i);
            }
            return list;
        }
    }

    //完全背包
    class Solution {
        /**
         * 参数：[n]
         * 返回值：int
         * 作者： ladidol
         * 描述：先得到完全平方数数组捏，想要得到最少数量，有1的存在，就一定能保证每一个数都是完全平方数的和
         * 2022年10月27日20:36:42
         */
        public int numSquares(int n) {
            List<Integer> squares = getSquares(n);
            int[] dp = new int[n + 1];
            //背包初始化
            int INF = n + 1;
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int i = 0; i < squares.size(); i++) {
                for (int j = squares.get(i); j < n + 1; j++) {
                    dp[j] = Math.min(dp[j], dp[j - squares.get(i)] + 1);
                }
            }
            return dp[n];


        }


        List<Integer> getSquares(int n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {//真就是这样写的捏。
                list.add(i * i);
            }
            return list;
        }
    }


}
