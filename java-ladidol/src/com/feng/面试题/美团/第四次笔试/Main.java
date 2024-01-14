package com.feng.面试题.美团.第四次笔试;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/2 19:06
 * @description: {}
 */
public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m= scan.nextInt();
        scan.nextLine();
        String[] nums = new String[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextLine();
        }
        String target = "meituan";
        int k = 0;
        int i = 0;
        while(k<target.length()&&i<n){
            char ch = target.charAt(k);
            for (int j = 0; j < nums[i].length(); j++) {
                if (nums[i].charAt(j)==ch){
                    k++;
                    break;
                }
            }
            i++;
        }
        System.out.println(k==target.length()?"YES":"NO");
    }

    private static void 第五题() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        Arrays.sort(nums);
        //两个两个的取
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0, j = 1; i < n && j < n; i += 2, j += 2) {
            int first = nums[i], end = nums[j];
            String s = new String(first + " " + end);
            map.put(s, 1);
        }
//        System.out.println("map = " + map);
        System.out.println(map.size());
    }

    private static void 第三题() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int max = Integer.MIN_VALUE;
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                first = scan.nextInt();
                max = first;
            } else {
                max = Math.max(max, scan.nextInt());
            }
        }
        if (max == first) {
            System.out.println(0);
            return;
        }
        int count = 0;
        while (max > first) {
            max /= 2;
            count++;
        }
        System.out.println(count);
    }

    private static void 第二题() {
        Scanner scan = new Scanner(System.in);
        int[] res = new int[26];
        int n = scan.nextInt();
        int len = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            char[] chars = s.toCharArray();
            for (int j = 0; j < len; j++) {
                res[chars[j] - 'a']++;
            }
        }

        if (res['m' - 'a'] > 0
                && res['e' - 'a'] > 0
                && res['i' - 'a'] > 0
                && res['t' - 'a'] > 0
                && res['u' - 'a'] > 0
                && res['a' - 'a'] > 0
                && res['n' - 'a'] > 0) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }


}
