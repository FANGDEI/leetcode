package com.feng.draft.template.alpha_beta搜索算法;

/**
 * @author: ladidol
 * @date: 2022/10/25 14:58
 * @description:
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        Class clazz = Class.forName("com.feng.draft.template.alpha_beta搜索算法.Student");



        System.out.println("student.getClass() = " + student.getClass());//动态获取
        System.out.println("Student.class = " + Student.class);//静态获取
        System.out.println("Class.forName = " + Class.forName("com.feng.draft.template.alpha_beta搜索算法.Student"));
        System.out.println("clazz = " + clazz);//和上面一样的，通过类名来找。

    }
}