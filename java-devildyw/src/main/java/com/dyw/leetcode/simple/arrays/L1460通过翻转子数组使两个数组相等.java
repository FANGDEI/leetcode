package com.dyw.leetcode.simple.arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-08-27-10:49
 * <p>
 * 给你两个长度相同的整数数组target和arr。每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 * <p>
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 */
@SuppressWarnings("all")
public class L1460通过翻转子数组使两个数组相等 {
    public static void main(String[] args) {

    }

    /**
     * 哈希表
     * @param target
     * @param arr
     * @return
     */
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : target) {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (int i : arr) {
            if (map.getOrDefault(i,0)==0){
                return false;
            }else{
                map.put(i,map.get(i)-1);
            }
        }
        return true;
    }
}
