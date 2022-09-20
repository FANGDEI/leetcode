package com.feng.draft;

import javafx.util.Pair;

import java.util.*;

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
    public static void main(String[] args) {
        int MOD = 1_000_000_007;
        int mod = (int) (10e9 + 7);
        System.out.println("mod = " + mod);
        System.out.println("MOD = " + MOD);
        System.out.println(mod == MOD);
    }

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
