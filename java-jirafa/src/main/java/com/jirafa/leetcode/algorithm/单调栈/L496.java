package com.jirafa.leetcode.algorithm.单调栈;

import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class L496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        stack.push(nums2[0]);
        for (int i= 1; i < nums2.length; i++) {
            while (!stack.isEmpty()&&stack.peek()<nums2[i]){
                Integer pop = stack.pop();
                if(map.containsKey(pop)){
                    res[map.get(pop)]=nums2[i];
                }
            }
            stack.push(nums2[i]);
        }

        return  res;
    }
}
