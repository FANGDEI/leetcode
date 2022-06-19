package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L54螺旋矩阵
 * @author: Ladidol
 * @description: 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 解题思路类似螺旋矩阵II那样,通过四种方向模拟就行
 * 始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环
 * <p>
 * <p>
 * https://leetcode.cn/problems/spiral-matrix/solution/by-shou-hu-zhe-t-7lii/
 * @date: 2022/6/19 12:28
 * @version: 1.0
 */
public class L54螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};

        System.out.println(new L54().spiralOrder(matrix));
        System.out.println(new Solution().spiralOrder(matrix));
    }
}
class L54 {

    //你会发现这个和II有点差别的，这里是从里面把东西给写出来，不能保证最后遍历的数字就是最大值
    //所以我们要每边的遍历后就要判断res数组是不是超过数字限制了，所以这里用flag保证顺序，再到if 和else if来保证每次循环都最多执行一次加入操作！


    //当然，没错的话，也可以和II中一样，只是每次缩小边界时都要判断一下是不是超出大小了。
    //            if (ans.size()==tar){
    //                return ans;
    //            }
    public List<Integer> spiralOrder(int[][] matrix) {
        //这里踩了一个坑，不要直接定义n，因为长宽可以不一样长，不是全是正方形的原因！
//        int n = matrix.length;
        int t = 0, r = matrix[0].length - 1, d = matrix.length - 1, l = 0;
        int tar = (r+1)*(d+1);
        List<Integer> ans=new ArrayList<>();
        int flag = 1;
        //跳出循环，是当数组中全部数字都被遍历完了。
        while(ans.size()<tar){
            //t缩 从左到右
            if(flag==1){
                for (int i = l; i <= r; i++) {
                    ans.add(matrix[t][i]);
                }
                t++;
                flag = 2;
            }

            //r缩 从上到下
            else if (flag==2){
                for (int i = t; i <= d; i++) {
                    ans.add(matrix[i][r]);
                }
                r--;
                flag = 3;
            }

            //d缩 从右到左
            else if (flag==3){
                for (int i = r; i >= l; i--) {
                    ans.add(matrix[d][i]);
                }
                d--;
                flag = 4;
            }

            //l缩 从下到上
            else if (flag==4){
                for (int i = d; i >= t; i--) {
                    ans.add(matrix[i][l]);
                }
                l++;
                flag = 1;
            }


        }
        return ans;
    }

}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int l=0,r=matrix[0].length-1,up=0,down=matrix.length-1;
        int f=0,num=(r+1)*(down+1);
        while(ans.size()!=num){
            if(f==0){
                for(int x=l;x<=r;x++){//左->右
                    ans.add(matrix[up][x]);
                }
                up++;//上指针++
                f=1;
            }else if(f==1){//上->下
                for(int y=up;y<=down;y++){
                    ans.add(matrix[y][r]);
                }
                r--;//右指针--
                f=2;
            }else if(f==2){
                for(int x=r;x>=l;x--){//右->左
                    ans.add(matrix[down][x]);
                }
                down--;//下指针--
                f=3;
            }else{
                for(int y=down;y>=up;y--){//下->上
                    ans.add(matrix[y][l]);
                }
                f=0;
                l++;//左指针++
            }
        }
        return ans;
    }
}

