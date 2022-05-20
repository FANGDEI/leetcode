package com.dyw.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Devil
 * @date 2022-05-20-13:54
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 */
@SuppressWarnings("all")
public class L594最长和谐子序列 {
    public static void main(String[] args) {

    }

    /**
     * map法
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.containsKey(key+1)){
                res = Math.max(res,map.get(key)+map.get(key+1));
            }
        }
        return res;
    }

    /**
     * 遍历枚举
     */
    public int findLHS01(int[] nums) {
        Arrays.sort(nums);
        //从第一个开始查找
        int begin = 0;
        int res = 0;

        //遍历排序后的数组
        for (int end = 0; end < nums.length; end++) {
            //如果nums[end] - nums[begin] > 1 那么begin++ 知道nums[end]-nums[begin] == 1
            //注意这里end是一直比begin大的
            while (nums[end]-nums[begin]>1){
                begin++;
            }
            //取res与end-begin+1之间的最大值
            if (nums[end]-nums[begin]==1){
                res = Math.max(res,end-begin+1);
            }
        }
        return res;
    }
}
