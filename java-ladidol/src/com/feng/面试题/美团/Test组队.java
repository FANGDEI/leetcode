package com.feng.面试题.美团;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/28 21:40
 * @description: {
 *     美团去年秋招面试题之一，yy提供的思路。
 * }
 */
public class Test组队 {

    /**
     * 递增的话，就是i和j满足了，就直接j-i个组合可以了，并直接跳出一个循环，然后j又可以往左边移动一个了
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        int ans = 0;
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (nums[i] + nums[j] >= x && nums[i] * nums[j] >= y) {
                    ans += j - i;
                    break;
                }
            }
        }
        System.out.println("ans = " + ans);
    }


}
