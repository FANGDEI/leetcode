package com.feng.draft.垃;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author Ladidol
 * @Date: 2022/3/30 20:24
 * @Version 1.0
 */
public class L15三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(new 三数之和双指针().threeSum(nums));
    }
}
/**
 * @Description: 双指针吊是吊,就是可能忘得快呀
 * @Author: ladidol
 * @Date: 2022/3/30 21:00 
 * @Param: 
 * @Return: 
 */
class 三数之和双指针 {
    public List<List<Integer>> threeSum(int[] nums) {
        //用双指针来做,其实有点像三指针了,i,left,right
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //i的每一个值可能都代表一个新的组合;
            if (nums[i] > 0) return lists;


            if (i > 0 && nums[i] == nums[i - 1]) {
                //有可能出现相同解的情况
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    //先将组合放进答案list中
                    //只要满足条件就不可能重复的,第一次有规定,后面都有限制的
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    //如果出现相同的情况,就自动跳到相同数的最后一个
                    while (left < right && nums[left + 1] == nums[left]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    //这时候在进行双指针移动
                    left++;
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){
                    //根据结果移动其中一个指针
                    left++;
                }else {
                    right--;
                }
            }
        }
        return lists;

    }
}
