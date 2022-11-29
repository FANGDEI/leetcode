package com.dyw.leetcode.TOP面试题;

/**
 * @author Devil
 * @since 2022-11-29-11:42
 */
@SuppressWarnings("all")
public class L11盛最多水的容器 {

    public static void main(String[] args) {
        System.out.println(new L11盛最多水的容器().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /**
     * 暴力解法 两层for
     * @param height
     * @return
     */
    public int maxArea01(int[] height) {
        int max = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max = Math.max((j-i)*Math.min(height[i],height[j]),max);
            }
        }
        return max;
    }

    /**
     * 双指针 从两边往中间寻找
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;

        /**
         * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 -1 变短：
         *
         * 若向内 移动短板（i 向右移动 i 变大） ，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
         * 若向内 移动长板（j 向左移动 j减小） ，水槽的短板 min(h[i], h[j])min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
         *
         */
        while (i < j) {
            res = height[i] < height[j] ? Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
