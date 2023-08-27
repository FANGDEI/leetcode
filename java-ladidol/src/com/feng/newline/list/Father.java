package com.feng.newline.list;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/22 12:21
 * @description: {}
 */
public class Father {





    String fatherName;

    private void privateMethod() {
        System.out.println("nihao privateMethod");
    }


    static void staticMethod() {
        System.out.println("nihao staticMethod");
    }

    public void publicMethod() {
        System.out.println("nihao publicMethod");
    }

    public class publicInnerClazz {
        String name;
    }

    private class privateInnerClazz {
        String name;
    }

    public void method1() {
        Integer num = 1;
        class methodClazz {
            Integer innerNum = num;//访问局部变量

        }


    }

    public void nimingInner() {

        ExecutorService executorService = Executors.newCachedThreadPool();

//        Future<?> submit = executorService.submit(new FutureTask<>(() - {
//
//        }));


        ArrayList<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        System.out.println("list = " + list);
    }


}
