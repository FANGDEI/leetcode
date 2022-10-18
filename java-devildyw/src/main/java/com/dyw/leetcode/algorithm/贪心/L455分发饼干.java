package com.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;

/**
 * 贪心的本质是选择每一阶段的局部最优，从而达到全局最优。
 * <p>
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * <p>
 * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * @author Devil
 * @since 2022-10-17-13:35
 */
@SuppressWarnings("all")
public class L455分发饼干 {

    public static void main(String[] args) {

    }

    /**
     * 贪心 用大饼干喂饱胃口大的
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        //先对小孩胃口和饼干数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        //饼干的指针
        int start = s.length - 1;
        //记录能满足的小孩数量
        int count = 0;

        //遍历 为了用饼干满足小孩 这里遍历以小孩胃口为基准 如果是用小饼干满足胃口小的小孩那么应该以饼干为基准
        for (int index = g.length - 1; index >= 0; index--) {
            //判断饼干指针是否有效 如果有效 判断是否满足当前小孩的胃口
            if (start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        //最终返回 满足小孩的数量
        return count;
    }


    /**
     * 小胃口 小饼干满足
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren01(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        //小孩胃口指针
        int start = 0;
        int count = 0;

        for (int i = 0; i < s.length && start < g.length; i++) {
            if (g[start] <= s[i]) {
                start++;
                count++;
            }
        }

        return count;
    }
}