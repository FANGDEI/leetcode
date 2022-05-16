package com.feng.draft;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: FibonacciSpatialComplexity
 * @author: Ladidol
 * @description: 看一下递归下的时间复杂度和空间复杂度
 * @date: 2022/5/16 12:09
 * @version: 1.0
 */
public class FibonacciSpatialComplexity {

    public static int fibonacci_普通(int i){
        if (i<=0){
            return 0;
        }
        if (i<3){
            return 1;
        }
        int first = 1;
        int second = 1;
        int temp;
        while(i>2){
            temp = first;
            first = second;
            second = temp + second;
            i--;
        }
        return second;
    }


    //空间复杂度o(n),时间复杂度o(2^n)
    public static int fibonacci_普通逆向递归(int i){
        if (i<=0){
            return 0;
        }
        if (i<3){
            return 1;
        }
        return fibonacci_普通逆向递归(i-1)+fibonacci_普通逆向递归(i-2);
    }

    //空间复杂度o(n),时间复杂度o(n);,,,,,因为每一次递归都会有空间消耗
    public static int fibonacci_正向递归优化(int first, int second, int i){
        if (i<=0){
            return 0;
        }
        if (i<3){
            //第一次放入的时候,first和second就一定是1
            return 1;
        }else if (i==3){
            //为递归返回最终值
            return first + second;
        }else{
            //超过3,就没超过一次就来一次加法, 当i==3时, 就可以得出结果了
            return fibonacci_正向递归优化(second,first+second,i-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(fibonacci_普通(8));
    }




}
