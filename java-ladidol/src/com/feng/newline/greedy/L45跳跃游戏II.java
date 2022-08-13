package com.feng.newline.greedy;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L45跳跃游戏II
 * @author: Ladidol
 * @description: 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * @date: 2022/8/13 17:29
 * @version: 1.0
 */
public class L45跳跃游戏II {
    //想要达到这样的效果，只要让移动下标，最大只能移动到nums.size - 2的地方就可以了。
    //因为当移动下标指向nums.size - 2时：
    //如果移动下标等于当前覆盖最大距离下标， 需要再走一步（即ans++），因为最后一步一定是可以到的终点。
    // （题目假设总是可以到达数组的最后一个位置）*****
    class Solution {
        public int jump(int[] nums) {
            int maxCover = 0;//下一覆盖的最远下标
            int end = 0;//当前覆盖的最远距离下标
            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {//这里有重要的处理
                maxCover = Math.max(maxCover, i + nums[i]);
                if (i == end) {
                    res++;
                    end = maxCover;
                }
            }
            return res;
        }
    }
    //dp可能会更简单一些。




}
