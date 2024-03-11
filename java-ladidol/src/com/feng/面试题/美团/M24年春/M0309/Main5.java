package com.feng.面试题.美团.M24年春.M0309;

import java.util.Scanner;

/**
 * 先假设只能通过一条关系来介绍
 */
public class Main5 {
    static int[] father;
    static int[] father2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int q = scan.nextInt();
        father = new int[n + n + 1];
        father2 = new int[n + n + 1];
        // init
        for (int i = 1; i <= n; i++) {
            father[i] = i;
            father2[i] = i;
        }
        // union
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            union(a, b);
            union2(b, a);
        }
        // query
        for (int i = 0; i < q; i++) {
            int check = scan.nextInt();

            int x = scan.nextInt();
            int y = scan.nextInt();
            if (check == 1) {
                // wangle
                union(x + n, y);
                union2(y + n, x);
            } else {
                boolean query = query(x, y);
                boolean query2 = query2(y, x);
                if (!query) {
                    // direct return
                    System.out.println("No");
                } else {
                    query = query(x + n, y);
                    query2 = query2(y + n, x);
                    if (query && query2) {
                        System.out.println("No");
                    } else {
                        System.out.println("Yes");
                    }
                }


            }
        }


    }

    static int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }

    static void union(int i, int j) {
        father[find(i)] = find(j);
    }

    static boolean query(int x, int y) {
        return find(x) == find(y);
    }


    static int find2(int x) {
        return x == father2[x] ? x : (father2[x] = find2(father2[x]));
    }

    static void union2(int i, int j) {
        father2[find2(i)] = find2(j);
    }

    static boolean query2(int x, int y) {
        return find2(x) == find2(y);
    }

}