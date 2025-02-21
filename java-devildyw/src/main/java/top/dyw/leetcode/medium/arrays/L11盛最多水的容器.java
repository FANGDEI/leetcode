package top.dyw.leetcode.medium.arrays;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/01/17 10:11
 **/
@SuppressWarnings("all")
public class L11盛最多水的容器 {

    public static void main(String[] args) {

    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length -1;

        int res = 0;
        while (left < right){
            if (height[left] < height[right]){
                res = Math.max(res, height[left] * (right - left));
                left++;
            } else{
                res = Math.max(res, height[right] * (right - left));
                right--;
            }
        }
        return res;
    }
}
