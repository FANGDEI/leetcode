package com.feng.draft;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: ArraysSort
 * @author: Ladidol
 * @description:
 * @date: 2022/8/9 22:48
 * @version: 1.0
 */
public class ArraysSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //对于逆序int数组。
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        System.out.println(Arrays.toString(nums));

        //对于Integer数组。
        Integer[] nums2 = {1, 2, 3};
        Arrays.sort(nums2, (o1, o2) -> o2 - o1);


    }
}
