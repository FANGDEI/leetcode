package com.feng.leetcode.LCCUP;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.LCCUP
 * @className: 第一题
 * @author: Ladidol
 * @description:
 * @date: 2022/9/24 15:19
 * @version: 1.0
 */
public class _1第一题气温变化趋势 {
//    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
//        int[] trendA = trend(temperatureA);
//        int[] trendB = trend(temperatureB);
//
//
//        int ans = 0;
//        for (int i = 0; i < trendA.length; i++) {
//            int max = 0;
//            int indexI = i;
//            int indexJ = 0;
//            for (int j = 0; j < trendB.length; j++) {
//                indexI = i;
//                if (trendA[indexI] == trendB[j]) {
//                    indexJ = j;
//                    int temp = 0;
//                    while (indexI < trendA.length
//                            && indexJ < trendB.length
//                            && trendA[indexI] != trendB[indexJ]) {
//                        temp++;
//                        indexI++;
//                        indexJ++;
//                    }
//                    max = Math.max(temp, max);
//                }
//            }
//            ans = Math.max(max, ans);
//        }
//        return ans;
//
//    }


    // dp求最长子数组：弄错了，必须是同样的起点
    //[1,-15,3,14,-1,4,35,36]
    //[-15,32,20,9,33,4,-1,-5]
    //尝试了一下这个实例，发现题意理解错了，必须是同一天，不能错位相比较。并不是比较最长子数组
    class Solution {
        // 正解
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {

            int[] trendA = trend(temperatureA);
            int[] trendB = trend(temperatureB);
            int ans = 0;
            for (int i = 0; i < trendA.length; i++) {
                int max = 0;
                while (i < trendA.length && trendA[i] == trendB[i]) {
                    i++;
                    max++;
                }
                ans = Math.max(max, ans);
            }
            return ans;
        }

        int[] trend(int[] temperature) {
            int[] tre = new int[temperature.length - 1];
            for (int i = 0; i < tre.length; i++) {
                if (temperature[i] < temperature[i + 1]) tre[i] = 1;
                else if (temperature[i] == temperature[i + 1]) tre[i] = 0;
                else tre[i] = -1;
            }
            return tre;
        }
    }


}
