package top.dyw.leetcode.hard.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/14 11:46
 **/
@SuppressWarnings("all")
public class L42接雨水 {

    public static void main(String[] args) {

    }

    /**
     * 单调栈， 递减栈
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        int result = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i]<height[stack.peek()]){
                stack.push(i);
            }else if (height[i]==height[stack.peek()]){
                stack.pop();
                stack.push(i);
            }
            else{
                int stackTop = stack.peek(); //之所以要记录stackTop 是为了计算整个容器的面积 一个面积可能分为上下两层计算具体结合图片理解
                while (!stack.isEmpty()&&height[i]>height[stackTop]){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.min(height[left],height[i]) - height[mid]; //计算得到装雨水容器的高 取较矮的边来减去最矮的底得到高
                        int w = i-left-1; //计算宽
                        int hold = h*w; //计算面积
                        if (hold>0) result+=hold; //相加
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}
