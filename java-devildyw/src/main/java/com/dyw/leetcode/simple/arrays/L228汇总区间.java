package com.dyw.leetcode.simple.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @date 2022-05-02-13:03
 * <p>
 * 给定一个 无重复元素 的有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */

@SuppressWarnings("all")
public class L228汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        ArrayList<String> strings = new ArrayList<>();
        int i = 0;
        //遍历数组
        while (i < length) {
            //记录区间开始下标
            int low = i;
            i++;
            //如果连续则继续遍历 知道不连续位置
            while (i < length && (nums[i] == nums[i - 1] + 1)) {
                i++;
            }
            //记录跳出循环的最后一个连续数字的下标
            int high = i - 1;
            //存入Stringbuffer中
            StringBuffer buffer = new StringBuffer(Integer.toString(nums[low]));
            //如果low 和 high不是同一个数字
            if (nums[low] != nums[high]) {
                buffer.append("->");
                buffer.append(Integer.toString(nums[high]));
            }
            strings.add(buffer.toString());

        }

        return strings;
    }
}
