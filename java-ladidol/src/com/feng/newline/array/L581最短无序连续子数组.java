package com.feng.newline.array;

import org.testng.reporters.jq.INavigatorPanel;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: ladidol
 * @date: 2022/10/4 14:10
 * @description: 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 */
public class L581最短无序连续子数组 {


    //听说直接先排序再对比
    class Solution {

        //nums = [2, ||6, 4, 8, 10, 9||, 15]
        //copy = [2, ||4, 6, 8, 9, 10||, 15]
        public int findUnsortedSubarray(int[] nums) {
//            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] copy = nums.clone();
            Arrays.sort(copy);
            int left = -1;
            int right = -1;
            boolean flag = true;
            int res = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != copy[i]) {
                    if (flag) {//第一次进入就是最左边
                        left = i;
                        flag = false;
                    } else {
                        right = i;
                        res = Math.max(right - left + 1, res);
                    }
                }
            }
            return res;
        }
    }
}