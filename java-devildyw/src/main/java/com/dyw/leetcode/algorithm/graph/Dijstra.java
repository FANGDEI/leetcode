package com.dyw.leetcode.algorithm.graph;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-08-26-12:26
 *
 * 迪杰斯特拉
 */
@SuppressWarnings("all")
public class Dijstra {
    private static int MaxValue = 100000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入顶点数和边数");
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        //初始化领接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //单源最短路径，源点
        int source = input.nextInt();
        //调用dijstra算法计算最短路径
        dijstra(matrix,source);
    }

    public static void dijstra(int[][] matrix, int source){
        //初始化最短路径长度的数组
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        //循环去更新 首先找到每一遍更新后的到达某点的最短路径 再借助其更新到达其他节点的路径 这样到最后就能得到一个由一点到达各个点的最短路径
        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //在未找出最短路径的节点中 找出权值最小的那个点
                if (visited[j]==0&&matrix[source][j]<min){
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径 这便是源节点到达j节点的最短距离 并且将j节点标识未已找到最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其他节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                //借助该点j更新到达其他节点的最短路径
                if (visited[m]==0&&matrix[source][index]+matrix[source][m]<matrix[source][m]){
                    //将数组中的路径更新
                    matrix[source][m] = matrix[source][index]+matrix[source][m];
                    //加入最短路径数组
                    path[m] = path[index] + "->" + m;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i!=source){
                if (shortest[i]==MaxValue){
                    System.out.println(source + "到" + i + "不可达");
                }else{
                    System.out.println(source + "到" + i + "最短路径为:" + path[i]);
                }
            }
        }


    }
}
