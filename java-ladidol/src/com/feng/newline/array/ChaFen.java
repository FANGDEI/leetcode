package com.feng.newline.array;

import java.util.Scanner;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: ChaFen
 * @author: Ladidol
 * @description:
 * @date: 2022/7/19 11:00
 * @version: 1.0
 */
public class ChaFen {
}
class TwoDimensionalPrefixSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        n = in.nextInt();
        m = in.nextInt();
        int[] a = new int[N], b = new int[N];
        for (int i=1; i<=n; i++) {
            a[i] = in.nextInt();
            b[i] = a[i] - a[i-1];
        }
        while (m != 0) {
            m--;
            int l, r, c;
            l = in.nextInt();
            r = in.nextInt();
            c = in.nextInt();
            b[l] += c;
            b[r+1] -= c;
        }
        for (int i=1; i<=n; i++) {
            b[i] += b[i-1];
            System.out.print(b[i] + " ");
        }
        in.close();
    }
    final static int N = (int)1e5 + 10;
}