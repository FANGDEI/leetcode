package com.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d< n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 * @author Devil
 * @since 2022-09-09-11:13
 */
@SuppressWarnings("all")
public class L18四数之和 {

    public static void main(String[] args) {

    }

    /**
     * 四数之和就是在三数之和的基础之上加了一层循环
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //如果排序后nums[1]>target了 那么也没有必要继续执行下去了
            //[-4, -3, -2, -1]，target是-10，不能因为-4 > -10而跳过。但是我们依旧可以去做剪枝，逻辑变成nums[i] > target && (nums[i] >=0 || target >= 0)就可以了。
            //但是如果nums[i]>=0了 因为排序过 所以后续出现的都是>0且>nums[i]的数 就不会出现上述情况了。
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            //去重
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                //去重
                if (j > i + 1 && nums[j-1]==nums[j]){
                    continue;
                }

                //初始化双指针
                int left = j+1;
                int right = nums.length - 1;
                //双指针搜索
                while (left < right){
                    long sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum>target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //去重
                        while (right > left && nums[right]==nums[right-1]){
                            right--;
                        }
                        while (right>left&&nums[left]==nums[left+1]){
                            left++;
                        }

                        right--;
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
