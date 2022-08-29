package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-08-29-10:54
 *
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
@SuppressWarnings("all")
public class L27移除元素 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 2, 3};
        new L27移除元素().removeElement(ints,2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 双指针  两层for循环也能做但是时间复杂度是O(n*n)
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        //快慢指针 slow和fast都从0开始增加 如果遇到快指针指向的元素值与val不相等就将其值覆盖到slow指针上 slow++
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=val){
                nums[slow++] = nums[fast];
            }
        }
        //最后返回覆盖后数组的长度即slow的长度 因为传入的数组是以引用的方式 所以到时以slow为长度的数组能够输出正确结果
        return slow;
    }
}
