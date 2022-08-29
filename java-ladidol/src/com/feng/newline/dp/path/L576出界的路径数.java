package com.feng.newline.dp.path;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L576出界的路径数
 * @author: Ladidol
 * @description: 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
 * 你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，
 * 找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * 示例 1：
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 * @date: 2022/8/26 21:56
 * @version: 1.0
 */
public class L576出界的路径数 {
    //可以想象是把三维dp压缩成了二维dp。
    class Solution {
        int mod = 1000000007;//(int)1e9+7
        int[][] dp;
        int m, n, N;

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            this.m = m;
            this.n = n;
            this.N = maxMove;
            dp = new int[m * n][N + 1];//一维指标是二维数组转化成的一维，二维指标是剩余的最大移动数目。

            //初始化边界走一步就到外面的元素。这些元素是源头。
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) initEdge(i, j);
                    if (j == 0) initEdge(i, j);
                    if (i + 1 == m) initEdge(i, j);
                    if (j + 1 == n) initEdge(i, j);
                }
            }


            //方向数组：技巧之一
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            //遍历是move从小到大，因为大的move依赖于晓得move。懂了。
            for (int move = 1; move <= N; move++) {
                for (int index = 0; index < m * n; index++) {//枚举所有位置
                    int x = parseIdx(index)[0], y = parseIdx(index)[1];//解析得到当前的x和y；
                    //下面要表示四个方向，为了不进行多的分类讨论，我们用个技巧：方向数组；
                    for (int[] dir : dirs) {
                        int tmpX = x + dir[0], tmpY = y + dir[1];
                        if (tmpX >= 0 && tmpX < m && tmpY >= 0 && tmpY < n) {//对于四个方向之一进行判断，如果位置有「相邻格子」，则「相邻格子」参与状态转移
                            int tmpIndex = getIndex(tmpX, tmpY);
                            dp[index][move] += dp[tmpIndex][move - 1];//累加一个方向的出去的结果。
                            dp[index][move] %= mod;//别忘记要取模
                        }
                    }
                }
            }
            return dp[getIndex(startRow, startColumn)][maxMove];
        }

        //初始化边界元素在每一个maxMove状态下的初始化。
        void initEdge(int x, int y) {
            int index = getIndex(x, y);
            for (int move = 1; move <= N; move++) {//注意至少还剩一步才能算一个路径。
                dp[index][move]++;
            }

        }

        // 将 (x, y) 转换为 index
        int getIndex(int x, int y) {
            return x * n + y;//注意这里是列数！！！
        }


        // 将 index 解析回 (x, y)
        int[] parseIdx(int index) {
            return new int[]{index / n, index % n};
        }
    }
}

