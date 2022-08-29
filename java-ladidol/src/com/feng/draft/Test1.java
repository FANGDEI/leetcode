package com.feng.draft;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: Test
 * @author: Ladidol
 * @description:
 * @date: 2022/8/15 20:05
 * @version: 1.0
 */
public class Test1 {
    //    public static void main(String[] args) {
//        int[][] erWei = {{1, 2}, {1, 3}, {4, 5},{2, 2}, {2, 3}, {4, 5},{1, 2}, {1, 3}, {4, 5}};
//
//        //单纯的二维排序，一个指标。
////        Arrays.sort(erWei, (a, b) -> Integer.compare(a[0], b[0]));
//        //二维数组排序，两个指标。
//        Arrays.sort(erWei, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];//从第二位的从小到大。
//            return a[0] - b[0];//这里是从大到小。
//        });
//        for (int[] ints : erWei) {
//            System.out.println(Arrays.toString(ints));
//        }
//    }
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public void Solution3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                map.put(new Pair<>(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return map.get(new Pair<>(i, j));
    }
}
