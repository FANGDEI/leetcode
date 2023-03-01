package com.feng.面试题.新希望六和.第六题;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/21 14:39
 * @description: {
 *     5151个
 * }
 */
public class Test6 {

    /**
     * 就是通过首尾指针模拟，从最外面开始
     * 1：[1,199]
     * 2：[2,198],[2,199]
     * 3：[3,197],[3,198],[3,199]
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 199; j >= 199 - i; j--) {
                count++;
                System.out.println("[ "+(i+1)+", "+j+" ]");
            }
        }
        System.out.println("count = " + count);

    }


}
