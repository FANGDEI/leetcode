package com.feng.draft.手撸.juc.unsafe类;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/25 22:40
 * @description: {}
 */
public class CasTest {

    //创建unsafe类型(不是启动类加载，就会抛异常)
//    final static Unsafe unsafe = Unsafe.getUnsafe();
    static Unsafe unsafe;

    static {
        unsafe = reflectGetUnsafe();
    }


    private volatile int a;

    public static void main(String[] args) {
        CasTest casTest = new CasTest();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                casTest.increment(i);
                System.out.print(casTest.a + " ");
            }
        }).start();
        new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                casTest.increment(i);
                System.out.print(casTest.a + " ");
            }
        }).start();
    }

    private void increment(int x) {
        while (true) {
            try {
                long fieldOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("a"));
                if (unsafe.compareAndSwapInt(this, fieldOffset, x - 1, x))
                    break;
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            System.out.println("e = " + e);
            return null;
        }
    }





}
