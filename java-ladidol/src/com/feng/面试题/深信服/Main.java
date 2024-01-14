package com.feng.面试题.深信服;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/6 19:31
 * @description: {}
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int k = scan.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(scan.nextInt());
            }
            List<Integer> index = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                index.add(i);
            }

            index.sort((a, b) -> nums.get(a) - nums.get(b));
            for (int i = n - 1; i >= k; i--) {
                nums.set(index.get(i), -1);
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (nums.get(i) != -1) {
                    sum += nums.get(i);
                }
            }
            int ans = Integer.MAX_VALUE;
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (nums.get(i) == -1) {
                    continue;
                }
                tmp += nums.get(i);
                ans = Math.min(ans, Math.max(tmp, sum - tmp));
            }

            System.out.println(ans);

        }


    }

    private static void 第二题() {
        Scanner scan = new Scanner(System.in);
//        String s = scan.nextLine();
        int n = scan.nextInt();
        int d = scan.nextInt();
        ArrayList<int[]> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] pair = new int[2];
            pair[0] = scan.nextInt();
            pair[1] = scan.nextInt();
            nums.add(pair);

        }
        nums.sort((a, b) -> a[0] - b[0]);
        int[] sum = new int[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums.get(i)[1];
        }
        for (int i = 0; i < n; i++) {
//            int j;
//            for (j = i; j < n; j++) {
//                if (nums.get(j)[0]>=nums.get(i)[0]+d){
//                    break;
//                }
//            }
//            ans = Math.max(ans, sum[j] - sum[i]);

            int targetLevel = nums.get(i)[0] + d;
            int left = i + 1;
            int right = n;
            int j = right;//初始化一個無效值
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums.get(mid)[0] >= targetLevel) {
                    j = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (j != n) {
                ans = Math.max(ans, sum[j] - sum[i]);
            }

        }
        System.out.println(ans);
    }

    private static void 第三題() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] split = s.split("\\s+");
//        int[] cnt = new int[128];
        HashMap<String, Integer> map = new HashMap<>();
        int n = split.length, ans = 0, left = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(split[i])) {
                left = Math.max(left, map.get(split[i]) + 1);
            }
            map.put(split[i], i);
            max = Math.max(max, i - left + 1);
        }


        System.out.println(max);
    }

    private static void 第一题() {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String regex = "^(?!-)(?!.*--\\.)[a-zA-Z0-9-]{1,63}(?:\\.[a-zA-Z]{1,63}){2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches());
    }
}