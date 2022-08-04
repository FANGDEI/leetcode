package com.dyw.leetcode.simple.arrays;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Devil
 * @date 2022-05-04-12:45
 * <p>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
@SuppressWarnings("all")
public class L349两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        //首先先创建两个set
        HashSet<Integer> integers = new HashSet<>();
        HashSet<Integer> integers1 = new HashSet<>();
        //先将一个数组的数据存储到hashset中
        for (int i : nums1) {
            integers.add(i);
        }
        //然后遍历另一个数组 这个过程中检查是否有与第一个set相同的元素 有就填入另一个set
        for (int i : nums2) {
            if (integers.contains(i)) {
                integers1.add(i);
            }
        }
        //将set转化为数组
        int[] ints = new int[integers1.size()];
        int i = 0;
        Iterator<Integer> iterator = integers1.iterator();
        while (iterator.hasNext()) {
            ints[i++] = iterator.next();
        }
        return ints;
    }

}
