package com.dyw.leetcode.algorithm.binarySearch;

/**
 * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 * <p>
 * 你可以做一些数量的移动 numMoves :
 * <p>
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 *
 * @author Devil
 * @since 2022-11-04-13:49
 */
@SuppressWarnings("all")
public class L754到达终点数字 {

    public static void main(String[] args) {
        System.out.println(new L754到达终点数字().reachNumber(2));
    }
    //fixme:看不懂题解
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target>0){
            k++;
            target-=k;
        }
        return target%2==0?k:k+1+k%2;
    }

}
