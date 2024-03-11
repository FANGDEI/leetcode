package com.feng.面试题.数字马力;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/10/9 19:05
 * @description: {}
 */
public class Test1 {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("1.0");
        System.out.print(a.equals(b));
        System.out.print(a.compareTo(b));
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key1", null);
        map.put(null, "value1");

    }

}
