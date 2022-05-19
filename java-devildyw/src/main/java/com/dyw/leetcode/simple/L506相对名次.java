package com.dyw.leetcode.simple;


import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Devil
 * @date 2022-05-19-16:06
 */
@SuppressWarnings("all")
public class L506相对名次 {
    public static void main(String[] args) {
        new L506相对名次().findRelativeRanks(new int[]{5,4,3,2,1});
    }

    /**
     * 截用hashmap保留原元素与下标的关系 对原数组排序 然后按照排序后的顺序按照从大到小遍历 每个元素都去访问map并向其获取原来的下标
     * 在原来的下标处存上对应的名次
     */
    public String[] findRelativeRanks01(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            //记录元素与下标之间的关系
            map.put(score[i],i);
        }
        Arrays.sort(score);
        int index = 0;
        //反向遍历数组 因为升序排序
        for (int i = length-1; i >=0; i--) {
            if (i>=length-3){
                //前三个获取在map中保存的原来的下标 并把desc中对应的元素赋值到其中.
                result[map.get(score[i])] = desc[index++];
            }else{
                //后续的元素获取在map中保存的原来的下标 并把length-i 即为名次
                result[map.get(score[i])] = Integer.toString(length-i);
            }
        }
        return result;
    }

    /**
     * 通过二维数组存储元素和下标的关系
     */
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] ints = new int[length][2];
        String[] result = new String[length];

        for (int i = 0; i < length; i++) {
            ints[i][0] = score[i];
            ints[i][1] = i;
        }
        //对二维数组进行排序 按值排序(a[0]);
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < length; i++) {
            if (i>=3) {
                //根据原下标进行填值
                result[ints[i][1]] = Integer.toString(i + 1);
            }
            else{
                result[ints[i][1]] = desc[i];
            }
        }

        return result;
    }



}
