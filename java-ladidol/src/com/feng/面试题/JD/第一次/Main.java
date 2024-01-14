package com.feng.面试题.JD.第一次;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/26 18:56
 * @description: {}
 */
public class Main {

    static class Bear {
        String key;
        Integer value;

        public Bear(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }


    public static void main(String[] args) {
//        第一题();

        //4 3
        //human 2
        //monster 3
        //monster 10
        //monster 1
        //1 2 N Y
        //1 4 Y N
        //2 3 Y Y

        // YYYN

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        pairs = new Bear[n];


        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int score = scan.nextInt();
            pairs[i] = new Bear(name, score);
        }
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            String c = scan.next();
            String d = scan.next();

//            System.out.println(a + " " + b + " " + c + " " + d + " ");

            check(a, b, c, d);
            check(b, a, d, c);
        }

        for (int i = 0; i < n; i++) {
            if (pairs[i] == null) {
                System.out.print("N");
            } else {
                System.out.print("Y");
            }
        }

    }

    static Bear[] pairs;

    public static void check(int a, int b, String c, String d) {
        if (pairs[a] == null || pairs[b] == null) {
            return;
        }

        if (pairs[a].getKey().equals(pairs[b].getKey())) {
            return;
        }
        if (pairs[a].getKey().equals("monster")) {//如果是monster

            if (pairs[b].getKey().equals("human") && d.equals("Y")) {//得知对方是人的话，直接干
                if (Objects.equals(pairs[a].getValue(), pairs[b].getValue())) {
                    pairs[a] = null;
                    pairs[b] = null;//都消失了
                    return;
                } else if (pairs[a].getValue() > pairs[b].getValue()) {
                    pairs[b] = null;
                    return;
                } else {
                    pairs[a] = null;
                    return;
                }
            }

        }

        if (pairs[a].getKey().equals("human")) {//如果是human
            if (d.equals("Y") && (pairs[b].getValue() < pairs[a].getValue())) {
                pairs[b] = null;
            }
        }


    }


    private static void 第一题() {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

//        int max = 0;

        for (int i = 0; i < n; i++) {
            int tmp = scan.nextInt();
//            int one = getOne(map, i + 1, tmp, max);
            int one = getOne(map, i + 1, tmp);
//            max = Math.max(one, max);
            System.out.print(one + " ");


        }
    }

    public static int getOne(Map<Integer, Integer> map, int index, int tmp) {
        int ans = index - tmp % index;
        while (true) {
            if (map.containsKey(ans)) {
                ans += index;
            } else {
                map.put(ans, 1);
                return ans;
            }
        }

//        return -1;
    }


}



