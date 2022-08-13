package com.feng.draft;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: ArraysSort
 * @author: Ladidol
 * @description:
 * @date: 2022/8/9 22:48
 * @version: 1.0
 */
public class Arrays的一些骚操作 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        //对于逆序int数组。
        nums = Arrays.stream(nums).boxed().sorted((a, b) -> b - a).mapToInt(p -> p).toArray();
        System.out.println(Arrays.toString(nums));

        //对于Integer数组。
        Integer[] nums2 = {1, 2, 3};
        Arrays.sort(nums2, (o1, o2) -> o2 - o1);

        // 将数组按照绝对值大小从大到小排序，注意要按照绝对值的大小
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        //一些Arrays.stream（）的骚操作！
        Arrays.stream(nums).max();
        Arrays.stream(nums).sum();
        Arrays.stream(nums).min();
        Arrays.stream(nums).average();


    }
}
