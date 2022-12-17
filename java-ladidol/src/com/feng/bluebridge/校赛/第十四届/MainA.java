package com.feng.bluebridge.校赛.第十四届;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/17 9:20
 * @description: {}
 */
public class MainA {
    public static void main(String[] args) throws IOException {
        //可以试一下快读，我超，快读雀氏有用也。
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strs = br.readLine().split(" ");
        long ans = 0;
        int cur = n;
        for (int i = 0; i < n; i++) {
            ans += (long) cur-- * Integer.parseInt(strs[i]);
        }
        System.out.println(ans);
    }

    private static void 依旧四个() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long ans = 0;
        int cur = n;
        for (int i = 0; i < n; i++) {
            ans += (long) cur-- * scan.nextInt();
        }
        System.out.println(ans);
    }

    private static void 暴力2() {//只过了四个
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cur = scan.nextInt();
            sum += cur;
            ans += sum;
        }
        System.out.println(ans);
    }

    private static void 暴力解法() {//只过了三个
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
//        System.out.println("nums = " + Arrays.toString(nums));
        //可以用递归来做or数学。先暴力一下
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                ans += nums[j];
            }
        }
        System.out.println(ans);
    }
}
