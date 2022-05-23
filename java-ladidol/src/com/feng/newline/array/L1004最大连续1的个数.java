package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1004最大连续1的个数 右边无脑滑动，左边看情况收缩
 * @author: Ladidol
 * @description: 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @date: 2022/5/22 12:42
 * @version: 1.0
 */
public class L1004最大连续1的个数 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new L1004().longestOnes(nums,2));
    }
}
class L1004 {
    public int longestOnes(int[] nums, int k) {
        int[] map = new int[2];
        int left = 0;
        int right = 0;
        int sameMaxNums = 0;
        while(right<nums.length){
            map[nums[right]]++;
            //只对1进行++
            sameMaxNums = Math.max(sameMaxNums,map[1]);
            if (right - left + 1 - sameMaxNums > k){
                map[nums[left]]--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}
