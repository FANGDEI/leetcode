package com.feng.面试题.第四题;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/21 14:02
 * @description: {
 * 建立一个方法isRight(int num)，判断当前数字num是不是符合条件的，如果符合条件的话就对结果加一
 * 36个
 *
 * }
 */
public class Test4 {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 100; i <= 999; i++) {
            count += isRight(i) ? 1 : 0;
        }
        System.out.println("count = " + count);
    }

    public static boolean isRight(int num) {
        int bai = num / 100;
        int shi = num / 10 - bai * 10;
        int ge = num - bai * 100 - shi * 10;
        int sum = bai * shi * ge;

        return sum == 20;
    }
}
