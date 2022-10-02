package com.feng.pat;

import java.util.Scanner;

/**
 * @author: ladidol
 * @date: 2022/10/2 22:04
 * @description:
 */
public class P1001害死人不偿命的3n加1猜想 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 0;
        while (n != 1) {
            if ((n & 1) == 1) n = (n * 3 + 1) / 2;
            else n = n / 2;
            ans++;
        }
        System.out.println(ans);
    }
}