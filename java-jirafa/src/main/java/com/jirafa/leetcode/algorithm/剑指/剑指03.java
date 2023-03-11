package com.jirafa.leetcode.algorithm.剑指;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 剑指03 {
    Set<Integer> set=new HashSet<>();
    public int findRepeatNumber(int[] nums) {
        for(int num:nums){
            if(!set.add(num))
                return num;
        }
        return -1;
    }
}
