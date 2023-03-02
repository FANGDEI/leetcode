package com.feng.draft;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template
 * @className: 求质数
 * @author: Ladidol
 * @description:
 * @date: 2022/9/16 21:30
 * @version: 1.0
 */
public class 求质数 {
    static int n = (int) (1e5 + 7);
    static int[] primes = new int[n];
    static boolean[] notPrime = new boolean[n];


    // 欧拉筛：埃氏筛的改进版本，通过内层for循环减少重复运算。
    public void eulerScreen(int n) {
        int k = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                primes[k++] = i;
            }
            for (int j = 0; primes[j] * i < n; j++) {
                notPrime[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }
    }


    static String num() {
        return "1";
    }


    public static void main(String[] args) {
//        new 求质数().eulerScreen(100000);
//        for (int i = 0; i < 100; i++) {
//            System.out.print(primes[i]+" ");
//        }
//        int a = 2;
//        int b = 3;
//        System.out.println("4" + a + b);
//        System.out.println(num() + a + b);
//        System.out.println(a + b + num());

        int shu = 4;
        System.out.println(shu > 4 ? 99.9 : 9);

        System.out.println(true ? 1 : 2);			// 1
        System.out.println(true ? 1 : 2.0);			// 1.0
        System.out.println(true ? 'a' : 2L);		// 97L
        System.out.println(true ? 'a' : 2);			// a
        System.out.println(true ? 'a' : Character.MAX_VALUE);		// a
        System.out.println(true ? 'a' : Character.MAX_VALUE + 1);	// 97
        System.out.println(Character.MAX_VALUE);
        System.out.println(Character.MAX_VALUE+1);

    }


}
