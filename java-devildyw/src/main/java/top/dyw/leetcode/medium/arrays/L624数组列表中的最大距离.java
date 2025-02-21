package top.dyw.leetcode.medium.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/02/19 09:50
 **/
@SuppressWarnings("all")
public class L624数组列表中的最大距离 {

    public static void main(String[] args) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(1);
        integers1.add(5);
//        integers1.add(3);
        arrayLists.add(integers1);
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers2.add(3);
        integers2.add(4);
        arrayLists.add(integers2);
//        ArrayList<Integer> integers3 = new ArrayList<>();
//        integers1.add(1);
//        integers1.add(2);
//        integers1.add(3);
//        arrayLists.add(integers3);
        System.out.println(new L624数组列表中的最大距离().maxDistance(arrayLists));
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int globalMin = arrays.get(0).get(0);
        int globalMinIdx = 0;
        int secondMin = Integer.MAX_VALUE;
        int globalMax = arrays.get(0).get(arrays.get(0).size()-1);
        int globalMaxIdx = 0;
        int secondMax = Integer.MIN_VALUE;

        //记录最大值和第二最大值、最小值和第二最小值

        for (int i = 1; i < arrays.size(); i++) {
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(arrays.get(i).size()-1);
            //更新全局最小
            if (curMin < globalMin){
                //更新全局最小值
                secondMin = globalMin;
                globalMin = curMin;
                globalMinIdx = i;
            } else {
                //如果全局最小值无需更新那么看看能否更新第二最小值
                if (curMin < secondMin) {
                    secondMin = curMin;
                }
            }

            //同理
            if (curMax > globalMax){
                secondMax = globalMax;
                globalMax = curMax;
                globalMaxIdx = i;
            } else {
                if (curMax > secondMax){
                    secondMax = curMax;
                }
            }
        }
        // 如果全局最大值和全局最小值不是来自同一数组那么直接返回两者差值
        if (globalMinIdx != globalMaxIdx){
            return globalMax - globalMin;
        } else {
            //如果是来自同一数组那么只能错位取值
            return Math.max(globalMax - secondMin, secondMax - globalMin);
        }

    }
}
