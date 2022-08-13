package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L55跳跃游戏
 * @author: Ladidol
 * @description: 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * @date: 2022/8/13 17:12
 * @version: 1.0
 */
public class L55跳跃游戏 {
    //这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！
    //每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
    //贪心算法局部最优解：在当前最大覆盖范围内，每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
    //局部最优推出全局最优，找不出反例，试试贪心！
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length <= 1) return true;
            int cover = 0;//默认覆盖到第0个
            for (int i = 0; i <= cover; i++) {//在覆盖范围内更新最大的覆盖范围 重点*****
                cover = Math.max(i + nums[i], cover);//最大覆盖范围，看是否需要更新。
                if (cover >= nums.length - 1) return true;
            }
            return false;
        }
    }
}
