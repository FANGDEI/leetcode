package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Devil
 * @date 2022-05-23-15:43
 *
 *
 * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，
 * 致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 */
@SuppressWarnings("all")
public class L645错误的集合 {
    public static void main(String[] args) {
        int[] errorNums = new L645错误的集合().findErrorNums(new int[]{1, 2, 2, 4});
        System.out.println(errorNums[0]+" : "+errorNums[1]);
    }

    /**
     * hash表
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count;
        for (int i = 1; i <= nums.length; i++) {
            count = map.getOrDefault(i,0);
            if (count>1){
                result[0] = i;
            }else if (count==0){
                result[1] = i;
            }
        }
        return result;
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int[] findErrorNums01(int[] nums) {
        int length = nums.length;
        int[] result = new int[2];
        //排序
        Arrays.sort(nums);
        //记录上一个元素的值 初始化为0 可以把0视为1的前一个元素
        int prev = 0;
        for (int i = 0; i < length; i++) {
            int curr = nums[i];
            //如果与上次的值相等那么该值重复
            if (curr==prev){
                result[0] = prev;
            } else if (curr-prev>1){
                //如果两个数的插值大于1那prev+1就是缺少的值 但是这样无法判断最有一个值是否错误 所以结尾需要判断
                result[1] = prev+1;
            }
            prev = curr;
        }
        //需要判断最有一个元素是不是错误元素
        if (nums[length-1]!=length){
            result[1] = length;
        }
        return result;
    }

}
