package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L798得分最高的最小轮调
 * @author: Ladidol
 * @description: 给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 * 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 * 输入：nums = [2,3,1,4,0]
 * 输出：3
 * 解释：
 * 下面列出了每个 k 的得分：
 * k = 0,  nums = [2,3,1,4,0],    score 2
 * k = 1,  nums = [3,1,4,0,2],    score 3
 * k = 2,  nums = [1,4,0,2,3],    score 3
 * k = 3,  nums = [4,0,2,3,1],    score 4
 * k = 4,  nums = [0,2,3,1,4],    score 3
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 * <p>
 * <p>
 * 所以我们应当选择k = 3，得分最高。
 * @date: 2022/7/25 11:59
 * @version: 1.0
 */
public class L798得分最高的最小轮调 {


    //核心就是, 坐标在[num, n-1]之间才score加一!!!!!!!
    class Solution {
        //一个k对应的score的差分,这样可以对其构造出差分数组diff
        //diff[i]的值的代表：与 diff [i-1]状态相比发生的score值的变化。
        public int bestRotation(int[] nums) {
            int n = nums.length;
            int[] diff = new int[n + 1];
            for (int i = 0; i < n; i++) {

                /*分类一:起点终点都在[num,n-1]; 分类二:起点终点都在[0,num-1]*/
                if (i >= nums[i]) {
                    diff[0]++;//不移动k=0就可以score加1. 有一个基础分.
                    diff[i - nums[i] + 1]--;//向左移出那个范围里面就一定会--;
                    diff[i + 1]++;//向左移动直到,k>=i+1就又都可以score加1;
                } else {
                    //不移动本身不会对答案作出贡献
                    diff[i + 1]++;//移动超过最左端0回到n-1，会对答案作出贡献
                    diff[i - nums[i] + 1 + n]--;//当继续移动，超过num回到[0, num - 1] 之间时，又不会再对答案做出贡献了
                }
            }
            int max = 0, ans = 0, cur = 0;
            for (int i = 0; i < n; i++) {
                //emm确实很像动态规划.维护当前k的score
                cur += diff[i];
                if (cur > max) {
                    ans = i;
                    max = cur;
                }
            }
            return ans;
        }
    }
}
