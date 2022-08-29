package com.feng.newline.hashtable;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1224最大相等频率
 * @author: Ladidol
 * @description: 给你一个正整数数组nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
 * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * @date: 2022/8/18 12:11
 * @version: 1.0 每日一题
 */
public class L1224最大相等频率 {
    //3种情况：
    //数字序列全是单个不同的数字，随便删哪个都行，那么有几个这样的数字，结果就是几。
    //数字组成为单一数字+若干组数目相同的数组，删除单一的那个数字后满足条件。
    //数字组成为若干组数目相同的数组+1组数目比其余大1的数组，单出最多的那个中的一个数字后满足条件。

    //翻译一下：
    //最多的数字个数为1；
    //最多的数字个数 * 最多的数字种类 + 1 = 当前遍历的数字个数；（这里的1是孤数，即单一的数字）
    //（最多的数字个数 - 1）* 数字种类 + 1 = 当前遍历的数字个数。（第一个-1即要从最多的那组里面删除一个数字，后面的+1即补回来删掉的数字）
    class Solution {
        public int maxEqualFreq(int[] nums) {
            int[] count = new int[100007];//后面可以试一下static
            int[] countType = new int[100007];
            int len = 0;
            int maxCount = 0;
            int res = 0;

            for (int num : nums) {
                len++;
                int curCount = ++count[num];
                countType[curCount]++;
                countType[curCount - 1]--;//更新频率最高的type个数，维护countType数组。
                maxCount = Math.max(maxCount, curCount);
                if (maxCount == 1) res = len;
                else if (maxCount * countType[maxCount] + 1 == len) res = len;
                else if ((maxCount - 1) * (countType[maxCount - 1] + 1) + 1 == len) res = len;

            }
            return res;
        }
    }
}
