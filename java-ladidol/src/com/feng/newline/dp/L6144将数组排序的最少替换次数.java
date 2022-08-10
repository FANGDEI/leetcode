package com.feng.newline.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L6144将数组排序的最少替换次数
 * @author: Ladidol
 * @description:
 * 给你一个下表从 0 开始的整数数组 nums 。每次操作中，你可以将数组中任何一个元素替换为 任意两个 和为该元素的数字。
 *
 * 比方说，nums = [5,6,7] 。一次操作中，我们可以将 nums[1] 替换成 2 和 4 ，将 nums 转变成 [5,2,4,7] 。
 * 请你执行上述操作，将数组变成元素按 非递减 顺序排列的数组，并返回所需的最少操作次数。
 * 示例 1：
 * 输入：nums = [3,9,3]
 * 输出：2
 * 解释：以下是将数组变成非递减顺序的步骤：
 * - [3,9,3] ，将9 变成 3 和 6 ，得到数组 [3,3,6,3]
 * - [3,3,6,3] ，将 6 变成 3 和 3 ，得到数组 [3,3,3,3,3]
 * 总共需要 2 步将数组变成非递减有序，所以我们返回 2 。
 * @date: 2022/8/7 12:54
 * @version: 1.0
 */
public class L6144将数组排序的最少替换次数 {
    // 听说是一个简单的贪心，从后往前检查，遇到nums[i]>nums[j]（i<j）时，
    // 我们只有一个原则，一定要让nums[i]每个拆出来的部分在不超过nums[j]的情况下尽可能拆得均匀，否则就提前降低了上限，会使得前面要拆分的数增加不必要的拆分次数。
    class Solution {
        public long minimumReplacement(int[] nums) {
            long count = 0;
            //倒序遍历
            for(int i=nums.length-2;i>=0;i--){
                //如果当前数小于上一个数
                if(nums[i]>nums[i+1]){
                    //拆分次数
                    count+= nums[i]/nums[i+1];
                    if(nums[i]%nums[i+1]==0){
                        //取余等于0，少拆分一次
                        count --;
                        //拆分后最小数 = nums[i+1]（取余等于0,拆分的所有数都等于nums[i+1]）
                        nums[i] = nums[i+1];
                    }else{
                        //拆分后最小数 = 当前数 / 拆分后数的数量
                        //（拆分后数的数量 = 拆分次数+1）
                        nums[i] = nums[i]/(nums[i]/nums[i+1]+1);
                    }
                }
            }
            return count;
        }
    }


}
