package com.feng.saike.第五届.B组初赛;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/11/26 15:42
 * @description:
 */
public class S2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = n - 1; i >= 0; i--) {
            a[i] = scan.nextInt();
        }
        for (int i = m - 1; i >= 0; i--) {
            b[i] = scan.nextInt();
        }
        List<Integer> res = new ArrayList<>();
        int pre = 0;
        int i = 0, j = 0;
        for (; i < n && j < m; i++, j++) {
            int jinzhi = i + 2;
            int sum = a[i] + b[j] + pre;
            int cha = sum - jinzhi;
            if (cha < 0) {
                pre = 0;
                res.add(sum);
            } else {
                res.add(cha);
                pre = 1;
            }
        }
        if (n >= m) {
            for (int k = i; k < n; k++) {
                int jinzhi = k + 2;
                int sum = a[k] + pre;
                int cha = sum - jinzhi;
                if (cha < 0) {
                    res.add(sum);
                    pre = 0;
                } else {
                    res.add(cha);
                    pre = 1;
                }
            }
        } else {
            for (int k = j; k < m; k++) {
                int jinzhi = k + 2;
                int sum = b[k] + pre;
                int cha = sum - jinzhi;
                if (cha < 0) {
                    res.add(sum);
                    pre = 0;
                } else {
                    res.add(cha);
                    pre = 1;
                }
            }
        }
        if (pre != 0) res.add(1);

        for (int k = res.size() - 1; k >= 0; k--) {
            System.out.print(res.get(k) + " ");
        }
        Collections.reverse(Arrays.asList(a));

    }
}