package com.dyw.leetcode.algorithm.贪心;

/**
 *
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
 *
 * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 *
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 *
 *
 * @author Devil
 * @since 2022-10-17-13:49
 */
@SuppressWarnings("all")
public class L376摆动序列 {

    public static void main(String[] args) {

    }

    /**
     * 贪心 记录数组中的封顶值 相当于将单调坡上的值删除 因为有单调坡就代表在这个坡上存在不是摆动序列的序列
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }

        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        //摆动序列至少为1 如果有两个元素至少为2 上面我们已经判断了当数组元素不大于1的情况了 现在数组长度至少为2所以这里我们初始化count 为 1
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i-1];
            //如果当前差值和上一个差值为 1 正 1负
            //等于0的情况标识初始化当前的 preDiff | preDiff 如果为0 表示前面有两个相等的值 而curDiff > 0 或 curDiff < 0 则表示当前这个值减去前面的值是大于或小于0的 所以这里相当于将相同的值删除
            //如果preDiff == 0 则默认当前的值为峰  实际上我们这个算法总是在认为坡上的第一个元素为峰顶元素.
            if ((curDiff>0&&preDiff<=0)||(curDiff<0&&preDiff>=0)){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

}
