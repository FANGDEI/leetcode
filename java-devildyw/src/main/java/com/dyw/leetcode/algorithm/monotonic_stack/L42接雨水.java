package com.dyw.leetcode.algorithm.monotonic_stack;

import java.util.Random;
import java.util.Stack;

/**
 * @author Devil
 * @since 2022-11-28-10:12
 */
@SuppressWarnings("all")
public class L42接雨水 {

    public static void main(String[] args) {

    }

    /**
     * 双指针做法
     *
     * 按列计算，除去第一列和最后一列的柱子 它所能装雨水的体积为它左右最高的柱子中其中最小的那根柱子减去它自己的高度
     * @param height
     * @return
     */
    public int trap01(int[] height) {
        int sum = 0;

        for (int i = 0; i < height.length; i++) {
            //第一个柱子和最后一个柱子不接雨水
            if (i==0||i==height.length-1){
                continue;
            }

            int rHight = height[i]; //记录右边柱子的最高高度
            int lHight = height[i]; //记录左边柱子的最高高度

            for (int r = i+1; r < height.length; r++) {
                if (height[r]>rHight) rHight = height[r];
            }
            //同理
            for (int l = i-1; l>=0; l--){
                if (height[l]>lHight) lHight = height[l];
            }

            int h = Math.min(lHight,rHight) - height[i];

            if (h>0) sum+=h;

        }

        return sum;

    }

    /**
     * 单调栈 按行遍历
     * 栈内元素的顺序为由栈顶向栈底由小到大排序 遇到比栈顶元素大的元素时就代表可能有凹槽了。
     * 而装水的部分起始就是栈顶和栈顶的下一个元素以及要入栈的三个元素来装
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int size = height.length;

        //如果height数组元素数量小于等于 2 无法构成容器 所以返回 0
        if (size<=2) return 0;

        //初始化栈
        Stack<Integer> stack = new Stack<>();
        //压入栈顶元素
        stack.push(0);

        int sum = 0;
        //遍历
        for (int i = 1; i < size; i++) {
            //如果当前遍历元素小于栈顶元素对应高度 则压入栈中
            if (height[i]<height[stack.peek()]){
                stack.push(i);

            //如果当前遍历元素等于栈顶元素对应高度 则原来的栈顶元素出栈 新的元素入栈
            }else if (height[i]==height[stack.peek()]){
                //因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index，push当前遍历的元素下标
                stack.pop();
                stack.push(i);
            }else{ //遇到大于栈顶元素的元素 有可能形成凹槽
                int heightAtIdx = height[i];
                //遍历所有小于当前元素的栈顶元素
                while (!stack.isEmpty()&&heightAtIdx>height[stack.peek()]){
                    //此时的栈顶可能是凹槽 所以需要出栈 找到栈顶的第二元素
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        //获取栈顶的第二元素
                        int left = stack.peek();

                        //在左右两个较高柱子之间取最小的那个值 减去凹槽的高度 得到就是装水的高度
                        int h = Math.min(height[left],height[i])-height[mid];
                        //在计算出宽
                        int w = i - left - 1;
                        sum+=h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
