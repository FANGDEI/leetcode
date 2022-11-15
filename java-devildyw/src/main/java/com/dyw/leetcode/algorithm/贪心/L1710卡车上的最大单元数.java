package com.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;

/**
 *
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 *
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 *
 * 返回卡车可以装载 单元 的 最大 总数。
 *
 *
 * @author Devil
 * @since 2022-11-15-10:46
 */
@SuppressWarnings("all")
public class L1710卡车上的最大单元数 {

    public static void main(String[] args) {
        System.out.println(new L1710卡车上的最大单元数().maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }

    /**
     * 贪心
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //排序 按降序排行
        Arrays.sort(boxTypes,(a,b)->{
            return b[1] - a[1];
        });
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[i][0]; j++) {
                sum+=boxTypes[i][1];
                truckSize--;
                if (truckSize==0){
                    return sum;
                }
            }
        }
        return sum;
    }
}
