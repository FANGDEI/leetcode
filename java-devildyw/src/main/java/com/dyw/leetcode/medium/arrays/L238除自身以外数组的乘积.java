package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-29-12:11
 * <p>
 * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 */
@SuppressWarnings("all")
public class L238除自身以外数组的乘积 {
    public static void main(String[] args) {

    }

    /**
     * 因为题目不允许使用除法
     * 所以我们使用两个数组 来分别存储每个元素的前缀元素乘积 和 后缀元素乘积
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[n];
        int[] R = new int[n];

        int[] answer = new int[n];

        //初始化数组首元素
        L[0] = 1;

        for (int i = 1; i < n; i++) {
            L[i] = nums[i-1]*L[i-1];
        }

        //R[i]为索引i右侧所有元素的乘积
        //对于索引为‘length-1’的元素，是因为右侧没有元素所以R[n-1] = 1
        R[n-1] = 1;
        for (int i = n-2; i>=0; i--){
            R[i] = nums[i+1]*R[i+1];
        }

        //对于索引i，除num[i]之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        //即对于索引i上的L[i]与R[i]的乘积
        for (int i = 0; i < n; i++) {
            answer[i] = L[i]*R[i];
        }

        return answer;
    }

    /**
     * 空间复杂度优化版本
     * @param nums
     * @return
     */
    public int[] productExceptSelf01(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        //先使用answer数组代替L数组 存储索引i元素的前缀元素乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1]*nums[i-1];
        }

        //使用单个遍历 动态构造R数组 初始为1
        int R = 1;
        for (int i = n-1; i>=0; i--){
            //每个R就是该索引i的后缀元素乘积
            answer[i] = answer[i]*R;
            //不断更新R
            R*=nums[i];
        }
        return answer;
    }
}
