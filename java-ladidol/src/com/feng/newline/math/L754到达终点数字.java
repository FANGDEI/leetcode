package com.feng.newline.math;

/**
 * @author: ladidol
 * @date: 2022/11/5 0:12
 * @description: 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * 你可以做一些数量的移动 numMoves :
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: target = 2
 * 输出: 3
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 -1 。
 * 第三次移动，从 -1 到 2 。
 * 示例 2:
 * <p>
 * 输入: target = 3
 * 输出: 2
 * 解释:
 * 第一次移动，从 0 到 1 。
 * 第二次移动，从 1 到 3 。
 *  
 * <p>
 * 提示:
 * <p>
 * -109 <= target <= 109
 * target != 0
 * 每日一题
 */
public class L754到达终点数字 {
    //copy的，有空回来做一下
    class Solution {
        public int reachNumber(int target) {
            if (target < 0) target = -target;
            int k = (int) Math.sqrt(2 * target), dist = k * (k + 1) / 2;
            while (dist < target || (dist - target) % 2 == 1) {
                k++;
                dist = k * (k + 1) / 2;
            }
            return k;
        }
    }
}