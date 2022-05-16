package com.feng.draft;

import java.util.Scanner;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: RecursionTimeComplexity
 * @author: Ladidol
 * @description:
 * @date: 2022/5/16 9:45
 * @version: 1.0
 */
public class RecursionTimeComplexity {
    //普通
    public static int common(int x, int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    //尝试递归算法1（o（n））
    public static int function1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return function1(x, n - 1) * x;
    }

    //尝试递归算法2依旧是（o（n））
    public static int function2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        //每一次都要分, 就是都要除以2, 只是要分类别处理
        if (n % 2 == 0) {
            //如果能拆分, 就的拆分
            return function2(x, n / 2) * function2(x, n / 2);
        } else {
            //如果是奇数次幂,就需要
            return function2(x, n / 2) * function2(x, n / 2) * x;
        }
    }


    //尝试递归算法3（o（lognn））
    public static int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int temp = function3(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        }
        return temp * temp * x;

    }

    public static void main(String[] args) {


        long startTime = System.currentTimeMillis();

        System.out.println(function1(2, 20));
//        function2(2,20);
//        function3(2,20);
        //要肉眼看出时间复杂度的区别的话, 需要用大数来算

        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        System.out.println("算法耗时 == " + costTime + "ms");
    }

}
