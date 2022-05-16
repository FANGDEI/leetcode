package com.dyw.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Devil
 * @date 2022-05-15-14:27
 *
 * 给你两个整数数组nums1 和 nums2，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 */
@SuppressWarnings("all")
public class L350两个数组的交集II {
    public static void main(String[] args) {
        new L350两个数组的交集II().intersect(new int[]{1,2,2,1},new int[]{2,2});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //将一个数组的元素存入hashmap中 key为元素值 value为count
        for (int i : nums1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] ints = new int[nums1.length];
        int index = 0;
        //遍历另一个数组
        for (int i : nums2) {
            //获取该数组元素对应的count 没有则为0
            Integer count = map.getOrDefault(i, 0);
            //如果count>0 就将其存入数组 并且count-- 表示该数已经计入结果集
            if (count>0){
                ints[index++] = i;
                count--;
                //如果count--后还是大于零 那么更新map中的该元素value
                if (count>0){
                    map.put(i,count);
                }else{
                    //否则移除
                    map.remove(i);
                }
            }
        }
        //将数组length拷贝一个新数组
        return Arrays.copyOfRange(ints,0,index);
    }
}
