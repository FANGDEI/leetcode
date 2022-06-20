package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L209长度最小的子数组
 * @author: Ladidol
 * @description: //第一个就是通过O(n^2)的方式来两个for循环暴力求解;
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * @date: 2022/5/22 10:44
 * @version: 1.0
 */
public class L209长度最小的子数组 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new L209().minSubArrayLen(6,nums));
    }
}
class L209 {
    //O(n)的复杂度
    /*
     * 2. 用滑动窗口来求解!
     * 窗口就是 满足其和 ≥ s 的长度最小的连续子数组。不断通过后指针向后面遍历控制。
     * 窗口的起始位置如何移动：如果当前窗口的值大于s了，前指针就要向前移动了（也就是该缩小了）。
     * 窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，后指针的起始位置设置为数组的起始位置就可以了。
     *
     *
     * 不要以为for里放一个while就以为是O(n^2)，
     * 主要是看每一个元素被操作的次数，
     * 每个元素在滑动窗后进来操作一次，
     * 出去操作一次，每个元素都是被被操作两次，
     * 所以时间复杂度是 2 × n 也就是O(n)。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int front = 0;
        int end = 0;
        int resultLen = Integer.MAX_VALUE;
        int sum = 0;//初始化子串的和为0
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            //只要一加上, 满足sum>=target, 就开始找最小长度
            while (sum>=target){
                int subLen = end - front + 1;
                resultLen = Math.min(subLen,resultLen);
                //精髓就是前收缩,后扩大
                sum -= nums[front++];
            }
        }
        if (resultLen == Integer.MAX_VALUE) return 0;
        return resultLen;
    }
    /*0(nlogn)的复杂度可以看一下*/

}
