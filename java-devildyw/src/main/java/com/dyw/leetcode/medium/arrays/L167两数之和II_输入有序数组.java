package com.dyw.leetcode.medium.arrays;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-07-13-10:39
 * <p>
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p>
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 */
@SuppressWarnings("all")
public class L167两数之和II_输入有序数组 {
    public static void main(String[] args) {
        int[] ints = new L167两数之和II_输入有序数组().twoSum(new int[]{2, 3, 4}, 6);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    /**
     * 这种方法可以做 但是很慢 官方不推荐
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    /**
     * 官方推荐做法之一 双指针
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum01(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        //因为数组是非递减的
        while (left < right) {
            //双指针
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }//如果结果小于target left++ 使得元素的值增大使其逼近
            else if (sum < target) {
                left++;
            }//如果结果大于target right-- 使得元素值减小使其逼近
            else {
                right--;
            }
            //因为我们一开始都是从两头开始遍历的 不用担心为什么target小了不是right增大之类的问题
        }
        return new int[]{-1, -1};
    }
}
