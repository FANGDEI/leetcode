package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L565数组嵌套
 * @author: Ladidol
 * @description:
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * @date: 2022/7/17 23:55
 * @version: 1.0
 */
public class L565数组嵌套 {

    public static void main(String[] args) {
        int[] nums = {5,4,0,3,1,6,2};
//        System.out.println(new Solution().arrayNesting(nums));
    }
    class Solution {
        public int arrayNesting(int[] nums) {
            //分析一下得知：就是找最大的那个圈！
            //用一个布尔类型的数组来做标记！
//        Boolean[] isHas = new Boolean[nums.length];//注意不要使用包装类，包装类默认是null，不是false；
            boolean[] isHas = new boolean[nums.length];
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (!isHas[i]){//如果不曾被遍历！
                    int count = 0;//初始化圈子的大小！
                    while(!isHas[i]){
                        isHas[i] = true;
                        count++;
                        i = nums[i];
                    }//跳出循环一定是头尾相接！
                    ans = Math.max(count,ans);
                }
            }
            return ans;
        }
    }

}