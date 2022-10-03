package com.feng.pat;

import java.util.*;

/**
 * @author: ladidol
 * @date: 2022/10/2 22:30
 * @description:
 */
public class P1002写出这个数 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] nums = str.toCharArray();
        int ans = 0;
        for (char num : nums) {
            ans += num - '0';
        }
        if (ans == 0) {
            System.out.println("ling");
            return;
        }

        List<Integer> list = new ArrayList<>();
        while (ans != 0) {
            int temp = ans % 10;
            list.add(temp);
            ans /= 10;
        }

        String[] pinYin = new String[]{"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};

        for (int i = list.size() - 1; i > 0; i--) {
            System.out.print(pinYin[list.get(i)] + " ");
        }
        System.out.print(pinYin[list.get(0)]);

    }
}