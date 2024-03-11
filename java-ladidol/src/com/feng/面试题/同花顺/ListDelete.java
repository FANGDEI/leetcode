package com.feng.面试题.同花顺;

import java.util.ArrayList;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/8 10:11
 * @description: {}
 */
public class ListDelete {
    public static void main(String[] args) {


    }


    private static void 迭代器() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("null");
        strings.add("ths");
        strings.add("null");

        for (String string : strings) {
            if ("null".equals(string)) {
                strings.remove(string);
            }
        }
        System.out.println("strings.get(0) = " + strings.get(0));
    }
}
