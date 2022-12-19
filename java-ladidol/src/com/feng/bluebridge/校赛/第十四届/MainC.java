package com.feng.bluebridge.校赛.第十四届;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/17 10:08
 * @description: {}
 */
public class MainC {//目前就两分


    //为了快速找到，最小到达一半的数字，我们可以尝试从中间开始遍历
    //当然也可以直接从k = 1开始遍历
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            long cur = scan.nextInt();
//            if (cur < 10) {
//                System.out.println(1);
//                continue;
//            }
            System.out.println(search(cur));
        }
    }

    static long search(long num) {

        for (int i = 1; i <= num / 2 + 1; i++) {
            long tmp = num;
            long a = 0;// 1/10
            long b = 0;// 去k个
            while (true) {
                if (b * 2 >= num) {
                    return i;
                }
                if (tmp == 0) {
                    break;
                }
                if (tmp < 10 && (tmp + b + tmp + b >= num)) {
                    return i;
                }
                if (tmp < 10) {
                    break;
                }
                long cha = tmp - i >= 0 ? i : tmp;
                tmp -= cha;
                b += cha;
                cha = tmp / 10;
                a += cha;
                tmp -= cha;
//                System.out.println("tmp = " + tmp + " b = " + b + " a = " + a);
            }
        }
        return num / 2 + 1;
    }

}
