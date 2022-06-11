package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L136只出现一次的数字
 * @author: Ladidol
 * @description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @date: 2022/6/9 20:17
 * @version: 1.0
 */
public class L136只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,1,3};
        System.out.println(new L136().singleNumber(nums));
    }
}
class L136 {
    /*异或运算!*/
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
