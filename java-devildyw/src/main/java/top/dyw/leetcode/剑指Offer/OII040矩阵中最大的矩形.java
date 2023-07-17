package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/17 13:23
 **/
@SuppressWarnings("all")
public class OII040矩阵中最大的矩形 {

    public static void main(String[] args) {

    }

    /**
     * 将题转换为求直方图最大矩形面积 OII39
     * @param matrix
     * @return
     */
    public int maximalRectangle(String[] matrix) {
        if (matrix==null||matrix.length == 0){
            return 0;
        }

        int[] heights = new int[matrix[0].length()];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历一列,更新高度
            for (int col = 0; col < matrix[0].length(); col++) {
                if (matrix[row].charAt(col)=='1'){
                    heights[col]+=1;
                }else{
                    heights[col]=0; //需要连续的1 如果不连续也就不参加后续的计算了
                }
            }
            //每一层都去计算从0~row的直方图最大矩形面积
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    //单调栈
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] newHeight = new int[heights.length + 2];
        Deque<Integer> stack = new ArrayDeque<>();

        System.arraycopy(heights,0,newHeight,1,heights.length);
        stack.push(0);

        for (int i = 1; i < newHeight.length; i++) {
            while (!stack.isEmpty()&&newHeight[i]<newHeight[stack.peek()]){
                //计算面积
                Integer mid = stack.pop();
                int height = newHeight[mid];
                int width = i-stack.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
