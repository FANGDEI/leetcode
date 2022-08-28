package com.feng.newline.hashtable;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1460通过翻转子数组使两个数组相等
 * @author: Ladidol
 * @description: 给你两个长度相同的整数数组target和arr。每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 * 示例 1：
 * <p>
 * 输入：target = [1,2,3,4], arr = [2,4,1,3]
 * 输出：true
 * 解释：你可以按照如下步骤使 arr 变成 target：
 * 1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * 2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * 3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * 上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 * 示例 2：
 * <p>
 * 输入：target = [7], arr = [7]
 * 输出：true
 * 解释：arr 不需要做任何翻转已经与 target 相等。
 * 示例 3：
 * <p>
 * 输入：target = [3,7,9], arr = [3,7,11]
 * 输出：false
 * 解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 * @date: 2022/8/25 23:00
 * @version: 1.0 每日一题
 */
public class L1460通过翻转子数组使两个数组相等 {
    class Solution {//脑筋急转弯，只有元素相同就一定可以true
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] hash = new int[1001];
            for (int num : arr) {
                hash[num]++;
            }
            for (int num : target) {
                hash[num]--;
                if (hash[num] < 0) return false;
            }
            return true;
        }
    }
}
