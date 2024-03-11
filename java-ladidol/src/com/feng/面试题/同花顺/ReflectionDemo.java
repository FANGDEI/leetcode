package com.feng.面试题.同花顺;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ReflectionDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        
        String value = "Hello, World!";
        
        try {
            Field elementDataField = ArrayList.class.getDeclaredField("elementData");
            elementDataField.setAccessible(true);
            Object[] elementData = (Object[]) elementDataField.get(list);
            
            elementData[0] = value;  // 存放 String 对象到 ArrayList<Integer>
            
//            Integer element = list.get(0);
            System.out.println(elementData[0]);  // 输出 "Hello, World!"
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}