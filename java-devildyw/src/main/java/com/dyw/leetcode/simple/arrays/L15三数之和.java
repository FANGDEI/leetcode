package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-25-11:26
 * <p>
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
@SuppressWarnings("all")
public class L15三数之和 {
    public static void main(String[] args) {

    }

    /**
     * 通过遍历首先找出第一个数 然后在这个数的索引后通过双指针找出剩余两个加起来值等于第一个值的相反数,对应值不能与上次遍历相同 否则容易出现完全相同的答案
     * <p>
     * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
     * <p>
     * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        //初始化排序
        Arrays.sort(nums);
        //初始化结果集
        ArrayList<List<Integer>> ans = new ArrayList<>();
        //双指针 枚举a
        for (int first = 0; first < n; first++) {
            // 需要和上一次枚举的数不相同 防止出现相同的答案
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //c 对应的指针初始指向数组最有端。
            int third = n - 1;
            int target = -nums[first];
            //枚举b
            for (int second = first + 1; second < n; second++) {
                //需要和上一次枚举的数不同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //需要保证b的指针在c的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                //如果指针重合，随着b后续的增加
                //就不会有满足 a+b+c=0 并且b<c的c了,可以退出循环
                if (second == third) {
                    break;
                }
                //如果b+c加起来等于-a 那么就将结果收入结果集
                if (nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }

            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum01(int[] nums) {
        int n = nums.length;
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //初始化指针c的指针 为数组最左边
            int third = n - 1;
            //初始化target 为 nums[first]的相反数 下面阶段我们需要找到两个数能使得两个数相加等于这个target
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                //要与上一枚举的数不同 防止答案重复
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //遍历找到合适的third
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                //如果相等后续的second 和 third之后的比较其实就是重复一遍由second到third相等 所以后续比较没有必要 直接退出该层循环
                //另一个前提 c的指针需要大于b的指针 该a没有对应的b和c能完成a+b+c=0 所以就跳出该层循环继续寻早下一个a
                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
