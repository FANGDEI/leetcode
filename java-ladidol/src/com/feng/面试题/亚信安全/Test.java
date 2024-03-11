package com.feng.面试题.亚信安全;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/27 19:08
 * @description: {}
 */
public class Test extends A {

    Test() {
        super("B");
        System.out.println("B");
    }

    public static void main(String[] args) {
        new Test();
    }


}


class C {
    C() {
        System.out.println("C");
    }
}

class A {
    C c = new C();

    A() {
        this("A");
        System.out.println("A");
    }

    A(String s) {
        System.out.println(s);
    }
}


























