package com.dyw.leetcode.algorithm.DFSAndBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Devil
 * @since 2022-07-17-11:25
 */
@SuppressWarnings("all")
public class L733图像渲染 {
    public static void main(String[] args) {

    }

    //上下左右用的位移数组
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    /**
     * 广度优先遍历
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //获取sr sc对应数组元素 如果它的颜色核newColor一致 那么不需要再渲染图像 直接返回图像
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int n = image.length, m = image[0].length;
        //借助队列完成广度优先搜索 将sr sc加入防止重复搜索
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        //将image[sr][sc]初始化为newColor
        image[sr][sc] = newColor;
        //开始搜索
        while (!queue.isEmpty()) {
            //队列中取出首个元素
            int[] cell = queue.poll();
            //获取到x坐标 核y坐标
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                //根据我们一开始的位移数组来改变x和y的值达到在方向上上下左右的目的
                int mx = x + dx[i], my = y + dy[i];
                //在有效范围内判断是否此时的x y坐标的值是需要渲染的值。
                if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
                    //是的话将该坐标加入队列 且渲染该点。
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }
}
