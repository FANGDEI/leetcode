package com.feng.面试题.得物;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/29 14:23
 * @description: {}
 */
public class Demo {
    static Demo demo = new Demo();
    static int a;
    static int b = 1;

    Demo() {
        a++;
        b++;
    }

    static Demo getInstance() {
        throw new OutOfMemoryError();
//        return demo;
    }

    public static void main(String[] args) {
        try {
            Demo demo = Demo.getInstance();
        } catch (Throwable e) {
            System.out.println("有bug" +
                    "");
        }
        System.out.println(a + " " + b);





    }


}
