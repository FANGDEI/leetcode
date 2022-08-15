package com.feng.newline.greedy;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L135分发糖果
 * @author: Ladidol
 * @description: n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * @date: 2022/8/14 17:33
 * @version: 1.0
 */
public class L135分发糖果 {
    /**
     * 分两个阶段
     * 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
     * 2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
     */
    class Solution {
        public int candy(int[] ratings) {
            int[] candy = new int[ratings.length];
            //先满足右边大于左边的情况。
            candy[0] = 1;
            for (int i = 1; i < ratings.length; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    candy[i] = candy[i - 1] + 1;
                } else {
                    candy[i] = 1;//默认没人都发
                }
            }
            //再满足左边大于右边的情况。
            for (int i = ratings.length - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candy[i] = Math.max(candy[i], candy[i + 1] + 1);
                }
            }
//            return Arrays.stream(candy).sum();//有点慢呀。
            int ans = 0;
            for (int s : candy) {
                ans += s;
            }
            return ans;
        }
    }
}
