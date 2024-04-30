package com.feng.draft.高频笔试手撕._1_单例模式;

/**
 * 枚举单例
 */
public enum 枚举单例 {

    INSTANCE(1, "xiaoxiao");

    private Integer num;
    private String name;

    private 枚举单例(int i, String xiaoxiao) {

    }

    // 公共方法（可以在外部访问）
    public void doSomething() {
        System.out.println("SingletonEnum is doing something...");
        System.out.println("Num: " + num + ", Name: " + name);
    }

}
