package com.feng.newline.list;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/22 12:25
 * @description: {}
 */
public class Son extends Father {

    String fatherName;//可以自己定义父类有的东西

    static void staticMethod() {
        com.feng.newline.list.Father.staticMethod();
        System.out.println("nihao son staticMethod");
    }





    @Override
    public void publicMethod() {
        super.publicMethod();
        System.out.println(" 重写咯 ");
//        BufferedInputStream bis = new BufferedInputStream(new FilterInputStream(""));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    publicInnerClazz clazz = new Father.publicInnerClazz();
//    privateInnerClazz clazz = new Father.privateInnerClazz();
}
