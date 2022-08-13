package com.feng.newline.greedy;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L455分发饼干
 * @author: Ladidol
 * @description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，
 * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *  
 * 示例 1:
 * <p>
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2
 * @date: 2022/8/13 14:49
 * @version: 1.0
 */
public class L455分发饼干 {
    //每个孩子最多只能得一个饼干
    //思路1：局部最优就是「大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个」，全局最优就是「喂饱尽可能多的小孩」。
    //思路2：我在想为啥这里不能是先小饼干先喂饱小胃口呢？答案当然是可以的！

    //思路2，从前往后遍历
    class Solution2 {
        public int findContentChildren(int[] g, int[] s) {

            Arrays.sort(g);//孩子
            Arrays.sort(s);//饼干
            int gIndex = 0;//孩子的编号，喂饱一个pass一个，所以遍历s
            int res = 0;
            for (int i = 0; i < s.length; i++) {
                if (gIndex >= g.length) return res;//剪枝，放在for循环中判断也行。
                if (g[gIndex] <= s[i]) {//当前最小需求值。
                    res++;
                    gIndex++;
                }
            }
            return res;
        }
    }

    //思路1：从后往前遍历
    class Solution {
        public int findContentChildren(int[] g, int[] s) {

            Arrays.sort(g);//孩子
            Arrays.sort(s);//饼干
            int sIndex = s.length - 1;//饼干编号，看谁能喂饱，喂饱一个pass一个饼干，所以遍历g
            int res = 0;
            for (int i = g.length - 1; i >= 0; i--) {
                if (sIndex < 0) return res;
                if (s[sIndex] >= g[i]) {//当前最大可给予值。
                    sIndex--;
                    res++;
                }
            }

            return res;
        }
    }


}
