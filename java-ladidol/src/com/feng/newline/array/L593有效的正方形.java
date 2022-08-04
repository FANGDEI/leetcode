package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L593有效的正方形
 * @author: Ladidol
 * @description: 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 * <p>
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 * <p>
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 * <p>
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 * <p>
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 * @date: 2022/7/29 15:09
 * @version: 1.0
 */
public class L593有效的正方形 {
    /*根据题意进行模拟即可。
      该图形是正方形，那么任意三点组成的一定是等腰直角三角形，用此条件作为判断。
    */
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            return isIsoscelesRightTriangle(p1, p2, p3)
                    &&isIsoscelesRightTriangle(p1, p2, p4)
                    &&isIsoscelesRightTriangle(p4, p2, p3)
                    &&isIsoscelesRightTriangle(p1, p4, p3);//全部满足才行
        }

        boolean isIsoscelesRightTriangle(int[] p1, int[] p2, int[] p3) {
            int d1 = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
            int d2 = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);
            int d3 = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
            return d1 > d2 && d2 == d3 && d1 == d2 + d3 ||
                    d2 > d3 && d1 == d3 && d2 == d1 + d3 ||
                    d3 > d1 && d2 == d1 && d3 == d2 + d1;//等腰直角三角形的三边关系,
        }
    }
}
