package com.feng.draft;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/2/11 17:35
 * @description: {}
 */
public class ClazzA extends Clazz {
//    @Override
//    public int get(int a, int b) {
//        return 1;
//    }


//    public short get(int a, int b) {
//        return 1;
//    }

    public int get(int a, String b) {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new ClazzA().get(3, 2));
    }
}
