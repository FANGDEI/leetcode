package com.feng.newline.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: 剑指offerL29顺时针打印矩阵
 * @author: Ladidol
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *示例:
 * 输入：matrix =
 * [[1,2,3]
 * ,[4,5,6]
 * ,[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 输入：matrix =
 * [[1,2,3,4]
 * ,[5,6,7,8]
 * ,[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * @date: 2022/6/19 13:17
 * @version: 1.0
 */
public class 剑指offer_L29顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.println(Arrays.toString(new 剑指offer_L29().spiralOrder(matrix)));
    }
}
class 剑指offer_L29 {


    //详情请见L54螺旋矩阵中备注
    //这题需要注意的就是, 返回的是数组int[]类型, 本题还悄悄多了一个判断条件(就是传入的数组需要判断是否为空哦)
    public int[] spiralOrder(int[][] matrix) {
        //看看二维数组是否为空
        int row = matrix.length;//行数
        if (row == 0) {
            return new int[0];
        }
        int col = matrix[0].length;//列数
        int t = 0, r = col - 1, d = row - 1, l = 0;
        int tar = (r+1)*(d+1);
        int[] ans=new int[tar];
        int flag = 1;
        int index = 0;//数组脚标
        //跳出循环，是当数组中全部数字都被遍历完了。
        while(index<tar){
            //t缩 从左到右
            if(flag==1){
                for (int i = l; i <= r; i++) {
                    ans[index++] = matrix[t][i];
                }
                t++;
                flag = 2;
            }

            //r缩 从上到下
            else if (flag==2){
                for (int i = t; i <= d; i++) {
                    ans[index++] = matrix[i][r];
                }
                r--;
                flag = 3;
            }

            //d缩 从右到左
            else if (flag==3){
                for (int i = r; i >= l; i--) {
                    ans[index++] = matrix[d][i];
                }
                d--;
                flag = 4;
            }

            //l缩 从下到上
            else if (flag==4){
                for (int i = d; i >= t; i--) {
                    ans[index++] = matrix[i][l];
                }
                l++;
                flag = 1;
            }


        }
        return ans;
    }
}
