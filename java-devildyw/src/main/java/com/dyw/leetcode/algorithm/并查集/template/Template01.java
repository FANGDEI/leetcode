package com.dyw.leetcode.algorithm.并查集.template;

import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-12-16-23:16
 */
public class Template01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        init(n+1);

        for (int i = 0; i < m; i++) {
            int z = input.nextInt();
            int x = input.nextInt();
            int y = input.nextInt();

            if (z==1){
                merge(x,y);
            }else{
                System.out.println(find(x)==find(y)?"Y":"N");
            }
        }
    }

    private static int[] fa;

    public static void init(int n){
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
    }

    public static int find(int x){
        return x==fa[x]?x:(fa[x] = find(fa[x]));
    }

    public static void merge(int i,int j){
        fa[find(i)] = find(j);
    }
}
