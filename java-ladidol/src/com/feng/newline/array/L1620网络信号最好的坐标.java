package com.feng.newline.array;

import java.util.PriorityQueue;

/**
 * @author: ladidol
 * @date: 2022/11/2 9:17
 * @description: 给你一个数组 towers 和一个整数 radius 。
 * 数组  towers  中包含一些网络信号塔，其中 towers[i] = [xi, yi, qi] 表示第 i 个网络信号塔的
 * 坐标是 (xi, yi) 且信号强度参数为 qi 。所有坐标都是在  X-Y 坐标系内的 整数 坐标。两个坐标之间的距离用 欧几里得距离 计算。
 * 整数 radius 表示一个塔 能到达 的 最远距离 。如果一个坐标跟塔的距离在 radius 以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，
 * 所以 radius 以外的距离该塔是 不能到达的 。
 * 如果第 i 个塔能到达 (x, y) ，那么该塔在此处的信号为 ⌊qi / (1 + d)⌋ ，其中 d 是塔跟此坐标的距离。
 * 一个坐标的 信号强度 是所有 能到达 该坐标的塔的信号强度之和。
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点 (cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * 注意：
 * <p>
 * 坐标(x1, y1) 字典序比另一个坐标 (x2, y2) 小，需满足以下条件之一：
 * 要么 x1 < x2 ，
 * 要么 x1 == x2 且 y1 < y2 。
 * ⌊val⌋ 表示小于等于 val 的最大整数（向下取整函数）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
 * 输出：[2,1]
 * 解释：
 * 坐标 (2, 1) 信号强度之和为 13
 * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
 * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
 * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
 * 没有别的坐标有更大的信号强度。
 * 提示：
 * <p>
 * 1 <= towers.length <= 50
 * towers[i].length == 3
 * 0 <= xi, yi, qi <= 50
 * 1 <= radius <= 50
 */
public class L1620网络信号最好的坐标 {

    //数组枚举
    class Solution {
        /**
         * 参数：[towers, radius]
         * 返回值：int[]
         * 作者： ladidol
         * 描述：直接遍历tower可能覆盖的范围，但是感觉挺高的时间复杂度的。
         */
        public int[] bestCoordinate(int[][] towers, int radius) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) return a[1] - b[1];
                    return a[0] - b[0];
                }
                return b[2] - a[2];
            });
            int n = 50;
            int m = 50;
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    int tmp = 0;
                    for (int[] tower : towers) {
                        tmp += getCoverPower(i, j, tower[0], tower[1], radius, tower[2]);
//                        tmp += tower[2]/(1+Math.sqrt(Math.pow(i - tower[0], 2) + Math.pow(j - tower[0], 2)));
                    }
                    queue.offer(new int[]{i, j, tmp});
                }
            }
            int[] poll = queue.poll();
            return new int[]{poll[0], poll[1]};
        }

        int getCoverPower(int x, int y, int a, int b, int radius, int power) {
            double dx = Math.pow(Math.abs(x - a), 2);
            double dy = Math.pow(Math.abs(y - b), 2);
            double d = Math.sqrt(dx + dy);
            if (d > radius) return 0;
            return (int) (power / (d + 1));
        }
    }


    public static void main(String[] args) {

        long num = 2020051035;
        //其中K=13+学号mod 4，
        System.out.println("(num % 4 + 13) = " + (num % 4 + 13));//16

        //(学号mod 9 +1)*100
        System.out.println("(num % 9 + 1) * 100 = " + (num % 9 + 1) * 100);//100
    }


}