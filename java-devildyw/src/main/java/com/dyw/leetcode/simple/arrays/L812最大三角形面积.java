package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-17-14:23
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。<br>
 *
 * <a href="https://baike.baidu.com/item/%E4%B8%89%E8%A7%92%E5%BD%A2%E9%9D%A2%E7%A7%AF%E5%85%AC%E5%BC%8F">三角形面积公式</a>
 * 这里我们使用的是行列式的形式
 */
@SuppressWarnings("all")
public class L812最大三角形面积 {
    public static void main(String[] args) {
        System.out.println(new L812最大三角形面积().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }

    /**
     * 通过遍历 使用三角形行列式的形式求得面积
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220617144148614.png" alt="图片">
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220617144332072.png" alt="图片">
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ret = 0.0;

        //遍历且三个不同的点
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    ret = Math.max(ret,triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return ret;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}
