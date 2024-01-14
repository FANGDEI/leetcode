package com.feng.面试题.百度.秋招;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/12 19:25
 * @description: {}
 * <p>
 * <p>
 * 4
 * 1 1
 * 1 4
 * 4 1
 * 4 4
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] nums = new int[n+1];
        int a = 0,b = 0;

        for (int i = 1; i <= n; i++) {
            nums[i] = scan.nextInt();
        }
        int count = 0;

        for (int i = 1; i <= k; i++) {
            if (nums[i] <= k){
                count++;
            }
        }
        if (count==k ||count == k-1){
            if (count==k){
                System.out.println("YES");
                System.out.println(0);
            }else{
                for (int i = 1; i <= k; i++) {
                    if (nums[i]!=nums[i-1]+1){
                        a = i;
                    }
                }
                for (int i = k+1; i <= n; i++) {
                    if (nums[i]==a){
                        b = i;
                    }
                }
                System.out.println("YES");
                System.out.println(1);
                System.out.println(a+" "+b);
            }

        }else{
            for (int i = k+1; i <= n; i++) {
                if (nums[i-k]<=k){//左区间
                    count--;
                }
                if (nums[i]<=k){
                    count++;
                }
                if (count==k){
                    System.out.println("YES");
                    System.out.println(0);
                }
                if (count==k-1){
                    for (int j = i-k+1; j <= i; j++) {
                        if (nums[j]!=nums[j-1]+1){
                            a = j;
                        }
                    }
                    for (int j = 1; j <= n; j++) {
                        if (nums[j]==a){
                            b = j;
                        }
                    }
                    System.out.println("YES");
                    System.out.println(1);
                    System.out.println(a+" "+b);
                }
            }
        }
        System.out.println("NO");



    }



    private static void 第一题() {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        for (int i = 0; i < k; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            if (check(n, m)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }


        }
    }

    private static boolean check(int n, int m) {
        boolean ans = false;
        if (n % 2 == 0) {
            ans = !ans;
        }
        if (m % 2 == 0) {
            ans = !ans;
        }
        if (n == m && n == 1) {
            ans = false;
        }
        return ans;

    }


}
