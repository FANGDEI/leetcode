package com.feng.面试题.神策数据;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/10 21:34
 * @description: {}
 */
public class Main1 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        int x = scan.nextInt();
        String[] staple11 = s1.split("\\s+");
        String[] drinks11 = s2.split("\\s+");

        int[] staple = new int[staple11.length];
        int[] drinks = new int[drinks11.length];

        for (int i = 0; i < staple11.length; i++) {
            staple[i] = Integer.valueOf(staple11[i]);
        }

        for (int i = 0; i < drinks11.length; i++) {
            drinks[i] = Integer.valueOf(drinks11[i]);
        }

        Arrays.sort(staple);
        Arrays.sort(drinks);

        long ans = 0;
        int mod = (int) (1e9 + 7);

        int j = drinks.length - 1;
        for (int i = 0; i < staple.length; i++) {
            while (j >= 0 && staple[i] + drinks[j] > x) {
                j--;
            }
            if (j == -1) break;
            ans += j + 1;
            ans %= mod;

        }

        int a = upper(staple, 0, staple.length, x);
        int b = upper(drinks, 0, drinks.length, x);
        ans = ans + a + b;




        System.out.println(ans);
    }

    static int upper(int[] nums, int l, int r, int value) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }


}
