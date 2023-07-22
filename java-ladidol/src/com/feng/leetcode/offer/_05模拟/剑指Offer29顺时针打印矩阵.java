package com.feng.leetcode.offer._05模拟;

public class 剑指Offer29顺时针打印矩阵 {


    //四边顺序遍历（模拟）
    class Solution {

        //所以我们要每边的遍历后就要判断res数组是不是超过数字限制了，所以这里用flag保证顺序，再到if 和else if来保证每次循环都最多执行一次加入操作！
        public int[] spiralOrder(int[][] matrix) {
            //offer中的这题，出现了一个[]空用例
            if (matrix.length == 0) return new int[]{};

            int d = matrix.length - 1, l = 0, t = 0, r = matrix[0].length - 1;
            int total = (r + 1) * (d + 1);//总数
            int index = 0;
            int[] res = new int[total];

            int flag = 1;
            //跳出循环，是当数组中全部数字都被遍历完了。
            while (index < total) {
                //t缩 从左到右
                if (flag == 1) {
                    for (int i = l; i <= r; i++) {
                        res[index++] = matrix[t][i];
                    }
                    t++;
                    flag = 2;
                }

                //r缩 从上到下
                else if (flag == 2) {
                    for (int i = t; i <= d; i++) {
                        res[index++] = matrix[i][r];
                    }
                    r--;
                    flag = 3;
                }

                //d缩 从右到左
                else if (flag == 3) {
                    for (int i = r; i >= l; i--) {
                        res[index++] = matrix[d][i];
                    }
                    d--;
                    flag = 4;
                }

                //l缩 从下到上
                else if (flag == 4) {
                    for (int i = d; i >= t; i--) {
                        res[index++] = matrix[i][l];
                    }
                    l++;
                    flag = 1;
                }


            }
            return res;
        }

    }

}
