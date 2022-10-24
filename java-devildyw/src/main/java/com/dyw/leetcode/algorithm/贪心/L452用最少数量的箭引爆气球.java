package com.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;

/**
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 *
 *
 * @author Devil
 * @since 2022-10-24-12:30
 */
@SuppressWarnings("all")
public class L452用最少数量的箭引爆气球 {

    public static void main(String[] args) {
        System.out.println(new L452用最少数量的箭引爆气球().findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            return a[1] - b[1];
        });
        int count = 1;
        int cur = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (cur>=points[i][0]&&cur<=points[i][1]){
                continue;
            }else{
                cur = points[i][1];
                count++;
            }
        }
        return count;
    }
}
