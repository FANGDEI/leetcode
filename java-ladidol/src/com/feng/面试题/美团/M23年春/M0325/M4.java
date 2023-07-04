package com.feng.面试题.美团.M23年春.M0325;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/25 20:18
 * @description: 样例输入
 * LOGNAME=default;SHELL=/bin/bash;HOME=/home/xiaomei;LOGNAME=xiaomei;
 * 4
 * SHELL
 * HOME
 * LOGNAME
 * logname
 * 样例输出
 * /bin/bash
 * /home/xiaomei
 * xiaomei
 * EMPTY
 */
public class M4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = scan.nextInt();
        scan.nextLine();

        String[] keys = new String[n];
        Map<String, String> map = new HashMap<>();
        String[] keysAndValues = s.split(";");

        for (int i = 0; i < n; i++) {
            keys[i] = scan.nextLine();
        }
        for (String keysAndValue : keysAndValues) {
            String[] split = keysAndValue.split("=");
            map.put(split[0], split[1]);
        }
//        System.out.println("keys = " + Arrays.toString(keys));
        for (int i = 0; i < n; i++) {
            System.out.println(map.getOrDefault(keys[i],"EMPTY"));
        }
    }
}
