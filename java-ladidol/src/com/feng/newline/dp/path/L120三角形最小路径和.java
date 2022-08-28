package com.feng.newline.dp.path;

import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L120三角形最小路径和
 * @author: Ladidol
 * @description: 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为11（即，2+3+5+1= 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * 进阶：
 * 你可以只使用 O(n)的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * @date: 2022/8/25 15:42
 * @version: 1.0
 */
public class L120三角形最小路径和 {
    //二维数组
    class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[][] dp = new int[m][n];
            for (int j = 0; j < triangle.get(0).size(); j++) {
                dp[0][j] = triangle.get(0).get(j);//第一行初始化；
            }
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);//第一列初始化。
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < triangle.get(i).size(); j++) {
                    if (j + 1 == triangle.get(i).size()) {//经过调试，最后一个可能会出现，使用上方不存在元素的值（value=0）
                        dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                    }
                }
            }

//            //输出一下dp来
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < triangle.get(i).size(); j++) {
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
            return Arrays.stream(dp[m - 1]).min().getAsInt();
        }
    }

    //一维数组 1）代码随想录版本
    class Solution2 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[] dp = new int[n];
            dp[0] = triangle.get(0).get(0);

            for (int i = 1; i < n; i++) {
                for (int j = triangle.get(i).size() - 1; j >= 0; j--) {//清楚理解j必须倒着来比遍历。
                    if (j == 0) {//第一列每一次的初始化
                        dp[j] = dp[j] + triangle.get(i).get(j);
                    } else if (j + 1 == triangle.get(i).size()) {//最后一列的特殊处理
                        dp[j] = dp[j - 1] + triangle.get(i).get(j);
                    } else {//状态转移方程
                        dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                    }
                }
            }
            return Arrays.stream(dp).min().getAsInt();
        }
    }


}
