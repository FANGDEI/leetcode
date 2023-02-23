package com.feng.面试题.第三题;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/21 14:11
 * @description: {
 * 27个
 * 通过新建一个isSquare(int num) 方法判断num的每一位是不是都是平方数，满足要求返回true；不满足返回false；
 * <p>
 * }
 */
public class Test3 {

    public static void main(String[] args) {
        //先维护一个一位数的平方数set
        set.add(1);
        set.add(4);
        set.add(9);
        //忘记算0了
        set.add(0);


        int count = 0;
        for (int i = 100; i <= 999; i++) {
            count += isSquare(i) ? 1 : 0;
        }
        System.out.println("count = " + count);
    }

    static Set<Integer> set = new HashSet<>();

    public static boolean isSquare(int num) {
        int bai = num / 100;
        int shi = num / 10 - bai * 10;
        int ge = num - bai * 100 - shi * 10;
        if (set.contains(bai) && set.contains(shi) && set.contains(ge)) {
            return true;
        }
        return false;

    }
}
