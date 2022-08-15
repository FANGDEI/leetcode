package com.feng.newline.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L452用最少数量的箭引爆气球
 * @author: Ladidol
 * @description: 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 * @date: 2022/8/15 0:23
 * @version: 1.0
 */


//直觉上来看，貌似只射重叠最多的气球，用的弓箭一定最少，那么有没有当前重叠了三个气球，我射两个，留下一个和后面的一起射这样弓箭用的更少的情况呢？
//尝试一下举反例，发现没有这种情况。
//那么就试一试贪心吧！局部最优：当气球出现重叠，一起射，所用弓箭最少。全局最优：把所有气球射爆所用弓箭最少。
public class L452用最少数量的箭引爆气球 {

    //如果气球重叠了，重叠气球中右边边界的最小值 之前的区间一定需要一个弓箭。
    class Solution {//先排序再进行从左向右遍历查看重叠，重叠越多越好。
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            //[[-2147483646,-2147483645],[2147483646,2147483647]],直接用基本数据类型int是会溢出。
            //因为使用int排序时有可能造成整型溢出,所以要使用Integer类
            //所以是Integer.compare(o1[0],o2[0])，其实就是三元表达式，防止出现-2147483646减去2147483646溢出成正数的情况。
            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
            //用三元表达式就行。但是这里不报错相等的情况。
            Arrays.sort(points, (a, b) -> a[0] > b[0] ? 1 : -1);

            int res = 1;//默认有气球就必须要有一个弓箭。
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > points[i - 1][1]) res++;
                else points[i][1] = Math.min(points[i][1], points[i - 1][1]);//必须更新一下这支弓箭在都扎破的情况下所能到的最远距离
            }
            return res;
        }
    }
}
