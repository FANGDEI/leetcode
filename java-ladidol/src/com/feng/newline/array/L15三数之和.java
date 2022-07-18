package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L15三数之和
 * @author: Ladidol
 * @description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 输入：nums = []
 * 输出：[]
 *
 * https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207181722856.gif
 *
 * @date: 2022/7/18 16:54
 * @version: 1.0
 */
public class L15三数之和 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        System.out.println(new Solution().threeSum(nums));
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //双指针法, left和right两个指针, i代表当前遍历进度.
            int i,left=0,right;
            ArrayList<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);//为了更好靠近目标值0, 需要两个指针配合缩小.
            for (i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    return result;
                }
                //答案中不可以包含重复的三元组。
                if (i>0&&nums[i]==nums[i-1]){
                    continue;
                }
                left = i+1;
                right = nums.length-1;
                while(left<right){
                    if (nums[i]+nums[left]+nums[right]==0){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        //这里要排除有相同的数字,走到最后一个咯
                        while(left<right&&nums[left]==nums[left+1]) left++;
                        while(left<right&&nums[right]==nums[right-1]) right--;

                        left++;
                        right--;
                    }else if (nums[i]+nums[left]+nums[right] < 0){
                        //小于目标值的话
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            return result;
        }
    }
}

