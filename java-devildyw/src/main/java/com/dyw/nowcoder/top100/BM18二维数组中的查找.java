package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2022-12-27-13:09
 */
@SuppressWarnings("all")
public class BM18二维数组中的查找 {

    public static void main(String[] args) {

    }

    public boolean Find(int target, int [][] array) {
        if (array.length==0){
            return false;
        }
        int n = array.length;
        if (array[0].length==0){
            return false;
        }
        /**
         * 这道题将条件简化了 一开始就从最左下角开始遍历 这样做的好处就是指针的方向是可以确定的最左代表这一行的最小值 最下代表同一竖列的最大值
         * 当不满足条件时我们就看也有方向地移动指针找到目标了
         */
        int m = array[0].length;
        //从最左下角开始往左或往上
        for (int i = n-1, j=0; i>=0&&j<m;){
            //元素较大，往上走
            if (array[i][j]>target){
                i--;
            } //元素较小，往右走
            else if (array[i][j]<target){
                j++;
            }else{
                return true;
            }
        }

        return false;
    }
}
