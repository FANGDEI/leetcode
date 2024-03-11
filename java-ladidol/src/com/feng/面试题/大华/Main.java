package com.feng.面试题.大华;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/8 21:45
 * @description: {}
 */
public class Main {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        Hashtable hashtable = new Hashtable();



        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);

    }

}
