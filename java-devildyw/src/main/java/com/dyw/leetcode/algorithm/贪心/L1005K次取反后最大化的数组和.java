package com.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * @author Devil
 * @since 2022-10-22-13:05
 */
@SuppressWarnings("all")
public class L1005K次取反后最大化的数组和 {

    public static void main(String[] args) {
        System.out.println(new L1005K次取反后最大化的数组和().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }


    /**
     * 贪心 两次贪心
     * 思路：
     * 局部最优：让绝对值大的负数变为正数，当前数值达到最大，整体最优：整个数组和达到最大。
     * 如果k还大于0 就进行下一步
     * 局部最优：只找数值最小的正整数进行反转，当前数值可以达到最大（例如正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个 数组和 达到最大。
     * <p>
     * 解题步骤：
     * 第一步：将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
     * 第二步：从前向后遍历，遇到负数将其变为正数，同时K--
     * 第三步：如果K还大于0，那么反复转变数值最小的元素，将K用完
     * 第四步：求和
     * @param nums
     * @param k
     * @return
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        //将数组按照绝对值大小从大到小排序
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int len = nums.length;

        for (int i = 0; i<len; i++){
            //从前往后遍历如果遇到负数将其变为正数，同时k--
            if (nums[i]<0&&k>0){
                nums[i] = -nums[i];
                k--;
            }
        }

        //如果k还大于0，那么反复转变为数值最小的元素，将k用光 这里优化 如果k为偶数则这里不变 为奇数则变一次
        if (k%2==1){
            nums[len-1] = - nums[len-1];
        }

        return Arrays.stream(nums).sum();
    }


}
