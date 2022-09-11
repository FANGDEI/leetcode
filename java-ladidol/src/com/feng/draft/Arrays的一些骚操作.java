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
        int[][] erWei = {{1, 2}, {1, 3}, {4, 5}};
        char[][] chessBoard = {{'1', '2'}, {'2', '4'}};

        //初始化二维数组
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');//快速初始化一维数组。
        }

        //对于逆序int数组。
        nums = Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> b - a)
                .mapToInt(p -> p)
                .toArray();
        System.out.println(Arrays.toString(nums));

        //对于Integer数组。
        Integer[] nums2 = {1, 2, 3};
        Arrays.sort(nums2, (o1, o2) -> o2 - o1);

        //二维数组排序（double类型）
        Arrays.sort(erWei, (a, b) -> Double.compare(a[0], b[0]));


        //二维数组排序。
        Arrays.sort(erWei, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];//从第二位的从小到大。
            return b[0] - a[0];//这里是从大到小。
        });
        //二维数组排序注意整数溢出。
        //[[-2147483646,-2147483645],[2147483646,2147483647]],直接用基本数据类型int是会溢出。
        //因为使用int排序时有可能造成整型溢出,所以要使用Integer
        //所以是Integer.compare(o1[0],o2[0])，其实源码就是三元表达式，防止出现-2147483646减去2147483646溢出成正数的情况。
        Arrays.sort(erWei, (a, b) -> Integer.compare(a[0], b[0]));
        //用三元表达式就行。但是这里不报错相等的情况。所以用上面那个就是最优解。
        Arrays.sort(erWei, (a, b) -> a[0] > b[0] ? 1 : -1);


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


        String text = "  this   is  a sentence ";
        //分割出单词
        String[] words = text.trim().split("\\s+");


        // 快速获得下标数组id = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        Integer[] id = IntStream.range(0, 10).boxed().toArray(Integer[]::new);



    }
}
