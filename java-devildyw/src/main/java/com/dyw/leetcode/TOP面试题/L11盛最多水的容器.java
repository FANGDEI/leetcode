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
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, res = 0;
        while (i<j){
            res = height[i]<height[j] ? Math.max(res,(j-i)*height[i++]) : Math.max(res,(j-i)*height[j--]);
        }
        return res;
    }
}
