package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/14 11:25
 **/
@SuppressWarnings("all")
public class OII039直方图最大矩形面积 {

    public static void main(String[] args) {
        new OII039直方图最大矩形面积().largestRectangleArea(new int[]{1,2,3,2,1});
    }

    public int largestRectangleArea(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights,0,newHeight,1,heights.length);
        //新数组前后赋值 防止特殊情况结果不准确
        newHeight[0] = 0;
        newHeight[newHeight.length-1] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); //单调栈存储下表索引，递增
        int result = 0;

        for (int i = 1; i < newHeight.length; i++) {
            while (!stack.isEmpty()&&newHeight[i]<newHeight[stack.peek()]){ //一旦有小于栈顶的元素则需要计算面积 可能栈顶元素就是最大的面积
                int mid = stack.pop(); //弹出栈顶元素（最高）计算
                int width = i-stack.peek()-1; //计算宽
                int height = newHeight[mid];
                result = Math.max(result,width*height); //计算面积
            }
            stack.push(i);
        }
        return result;
    }
}
